package com.example.smilinno_ameri.data.repository

import com.example.smilinno_ameri.data.source.RemoteDataSource
import com.example.smilinno_ameri.model.ResponseDetail
import com.example.smilinno_ameri.model.ResponseLatest
import com.example.smilinno_ameri.model.ResponsePopular
import com.example.smilinno_ameri.model.ResponseSliders
import com.example.smilinno_ameri.util.NetworkResponseCode
import com.example.smilinno_ameri.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor(private val remote: RemoteDataSource) {

    //slider
    suspend fun getSliders() : Flow<NetworkResult<ResponseSliders>> {
        return flow {
            emit(NetworkResult.Loading())
            emit(NetworkResponseCode(remote.getSliders()).generalNetworkResponse())
        }
    }
    //latest
    suspend fun getLatest(sortType:String) : Flow<NetworkResult<ResponseLatest>> {
        return flow {
            emit(NetworkResponseCode(remote.getLatest(sortType)).generalNetworkResponse())
        }
    }
    //popular
    suspend fun getPopular(sortType:String) : Flow<NetworkResult<ResponsePopular>> {
        return flow {
            emit(NetworkResponseCode(remote.getPopular(sortType)).generalNetworkResponse())
        }
    }
}