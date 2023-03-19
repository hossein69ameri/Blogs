package com.example.smilinno_ameri.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smilinno_ameri.data.repository.DetailRepository
import com.example.smilinno_ameri.data.repository.HomeRepository
import com.example.smilinno_ameri.model.ResponseDetail
import com.example.smilinno_ameri.model.ResponsePopular
import com.example.smilinno_ameri.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: DetailRepository) : ViewModel() {

    //popular blog
    private val _DetailState : MutableStateFlow<NetworkResult<ResponseDetail>?> = MutableStateFlow(null)
    val detailState = _DetailState.asStateFlow()

    fun postDetail(id:Int) = viewModelScope.launch {
        repository.postDetail(id).collect{
            _DetailState.value = it
        }
    }
}