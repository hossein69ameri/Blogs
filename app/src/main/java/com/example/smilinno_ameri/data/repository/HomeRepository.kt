package com.example.smilinno_ameri.data.repository

import com.example.smilinno_ameri.data.source.RemoteDataSource
import com.example.smilinno_ameri.model.ResponseSliders
import com.example.smilinno_ameri.util.NetworkResponseCode
import com.example.smilinno_ameri.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor(private val remote: RemoteDataSource) {

    suspend fun getSliders() : Flow<NetworkResult<ResponseSliders>> {
        return flow {
            emit(NetworkResult.Loading())
            emit(NetworkResponseCode(remote.getSliders()).generalNetworkResponse())
        }
    }
}