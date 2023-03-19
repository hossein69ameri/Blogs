package com.example.smilinno_ameri.data.repository

import com.example.smilinno_ameri.data.source.RemoteDataSource
import com.example.smilinno_ameri.model.ResponseDetail
import com.example.smilinno_ameri.util.NetworkResponseCode
import com.example.smilinno_ameri.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailRepository @Inject constructor(private val remote: RemoteDataSource) {

    //post detail
    suspend fun postDetail(id:Int) : Flow<NetworkResult<ResponseDetail>> {
        return flow {
            emit(NetworkResult.Loading())
            emit(NetworkResponseCode(remote.postDetail(id)).generalNetworkResponse())
        }
    }

}