package com.example.smilinno_ameri.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smilinno_ameri.databinding.FragmentHomeBinding
import com.example.smilinno_ameri.util.NetworkResult
import com.example.smilinno_ameri.util.isVisible
import com.example.smilinno_ameri.viewmodel.HomeViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var sliderAdapter: SliderAdapter

    @Inject
    lateinit var latestAdapter: LatestAdapter

    @Inject
    lateinit var popularAdapter: PopularAdapter

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getSliders()
        homeViewModel.getLatest("Latest")
        homeViewModel.getPopular("Popular")

        lifecycleScope.launchWhenCreated {
            homeViewModel.slidersState.collectLatest {
                if (it != null) {
                    when (it){
                        is NetworkResult.Loading -> {
                            binding.progressHome.isVisible(true,binding.viewPager)
                        }
                        is NetworkResult.Success -> {
                            binding.progressHome.isVisible(false,binding.viewPager)
                            if (it.data != null){
                            sliderAdapter.differ.submitList(it.data)
                                binding.viewPager.adapter = sliderAdapter
                            }
                        }
                        is NetworkResult.Error -> {
                            binding.progressHome.isVisible(false,binding.viewPager)

                        }
                    }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            homeViewModel.latestState.collectLatest {
                if (it != null) {
                    when (it){
                        is NetworkResult.Success -> {
                            if (it.data != null){
                                latestAdapter.differ.submitList(it.data)
                                binding.recyclerLatest.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                                binding.recyclerLatest.adapter = latestAdapter
                            }
                        }
                        is NetworkResult.Error -> {
                             Snackbar.make(binding.root,"Error",Snackbar.LENGTH_SHORT).show()
                        }
                        else -> {}
                    }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            homeViewModel.popularState.collectLatest {
                if (it != null) {
                    when (it){
                        is NetworkResult.Success -> {
                            if (it.data != null){
                                popularAdapter.differ.submitList(it.data)
                                binding.recyclerPopular.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                                binding.recyclerPopular.adapter = popularAdapter
                            }
                        }
                        is NetworkResult.Error -> {
                            Snackbar.make(binding.root,"Error",Snackbar.LENGTH_SHORT).show()
                        }
                        else -> {}
                    }
                }
            }
        }

    }
}