package com.example.smilinno_ameri.data.source

import com.example.smilinno_ameri.data.network.ApiServices
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: ApiServices) {
    suspend fun getSliders() = api.getSliders()
    suspend fun getLatest(sortType:String) = api.getLatest(sortType)
    suspend fun getPopular(sortType:String) = api.getPopular(sortType)
}