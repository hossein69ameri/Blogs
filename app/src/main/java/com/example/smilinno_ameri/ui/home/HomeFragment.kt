package com.example.smilinno_ameri.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.smilinno_ameri.databinding.FragmentHomeBinding
import com.example.smilinno_ameri.util.NetworkResult
import com.example.smilinno_ameri.util.isVisible
import com.example.smilinno_ameri.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var sliderAdapter: SliderAdapter

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getSliders()

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

    }
}