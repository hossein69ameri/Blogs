package com.example.smilinno_ameri.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smilinno_ameri.data.repository.HomeRepository
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

    fun getSliders() = viewModelScope.launch {
        repository.getSliders().collect{
            _slidersState.value = it
        }
    }


}