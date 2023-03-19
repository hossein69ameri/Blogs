package com.example.smilinno_ameri.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.smilinno_ameri.R
import com.example.smilinno_ameri.databinding.FragmentDetailBinding
import com.example.smilinno_ameri.util.NetworkResult
import com.example.smilinno_ameri.util.isVisible
import com.example.smilinno_ameri.viewmodel.DetailViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import org.jsoup.Jsoup
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    @Inject lateinit var detailAdapter: DetailAdapter
    private val detailViewModel : DetailViewModel by viewModels()
    private val args : DetailFragmentArgs by navArgs()
    private var blogID = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //get id
        blogID = args.blogID
        //call api
        detailViewModel.postDetail(blogID)
        //display detail
        lifecycleScope.launchWhenCreated {
            detailViewModel.detailState.collectLatest {
                if (it != null) {
                    when (it) {
                        is NetworkResult.Loading -> {
                            binding.progressDetail.isVisible(true, binding.containerDetail)
                        }
                        is NetworkResult.Success -> {
                            binding.progressDetail.isVisible(false, binding.containerDetail)
                            if (it.data != null) {
                                binding.apply {
                                    titleDetail.text = it.data.title
                                    imgDetail.load(it.data.path)
                                    dateDetail.text = it.data.date
                                    val dec = it.data.body?.let { it1 -> Jsoup.parse(it1).text() }
                                    bodyDetail.text = dec
                                    authorDetail.text = it.data.author
                                }
                                detailAdapter.differ.submitList(it.data.comments)
                                binding.recyclerDetail.layoutManager = LinearLayoutManager(requireContext())
                                binding.recyclerDetail.adapter = detailAdapter
                            }
                        }
                        is NetworkResult.Error -> {
                            binding.progressDetail.isVisible(false, binding.containerDetail)
                            Snackbar.make(binding.root, "Error", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

    }

}