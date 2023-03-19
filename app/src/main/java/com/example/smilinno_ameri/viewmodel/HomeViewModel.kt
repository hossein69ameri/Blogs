package com.example.smilinno_ameri.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smilinno_ameri.data.repository.HomeRepository
import com.example.smilinno_ameri.model.ResponseLatest
import com.example.smilinno_ameri.model.ResponsePopular
import com.example.smilinno_ameri.model.ResponseSliders
import com.example.smilinno_ameri.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    private val _slidersState : MutableStateFlow<NetworkResult<ResponseSliders>?> = MutableStateFlow(null)
    val slidersState = _slidersState.asStateFlow()

    private val _LatestState : MutableStateFlow<NetworkResult<ResponseLatest>?> = MutableStateFlow(null)
    val latestState = _LatestState.asStateFlow()

    private val _PopularState : MutableStateFlow<NetworkResult<ResponsePopular>?> = MutableStateFlow(null)
    val popularState = _PopularState.asStateFlow()

    fun getSliders() = viewModelScope.launch {
        repository.getSliders().collect{
            _slidersState.value = it
        }
    }

    fun getLatest(sortType:String) = viewModelScope.launch {
        repository.getLatest(sortType).collect{
            _LatestState.value = it
        }
    }

    fun getPopular(sortType:String) = viewModelScope.launch {
        repository.getPopular(sortType).collect{
            _PopularState.value = it
        }
    }


}