package com.example.smilinno_ameri.data.source

import com.example.smilinno_ameri.data.network.ApiServices
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: ApiServices) {
    //slider
    suspend fun getSliders() = api.getSliders()
    //latest
    suspend fun getLatest(sortType:String) = api.getLatest(sortType)
    //popular
    suspend fun getPopular(sortType:String) = api.getPopular(sortType)
}