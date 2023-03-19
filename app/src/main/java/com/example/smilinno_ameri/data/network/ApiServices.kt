package com.example.smilinno_ameri.data.network

import com.example.smilinno_ameri.model.ResponseLatest
import com.example.smilinno_ameri.model.ResponseSliders
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("/api/v1/sliders")
    suspend fun getSliders(): Response<ResponseSliders>


    @GET("/api/v1/blogs")
    suspend fun getLatest(@Query("sortType") sortType: String): Response<ResponseLatest>



}