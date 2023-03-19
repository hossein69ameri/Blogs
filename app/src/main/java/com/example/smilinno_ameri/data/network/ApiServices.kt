package com.example.smilinno_ameri.data.network

import com.example.smilinno_ameri.model.ResponseDetail
import com.example.smilinno_ameri.model.ResponseLatest
import com.example.smilinno_ameri.model.ResponsePopular
import com.example.smilinno_ameri.model.ResponseSliders
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    //slider
    @GET("/api/v1/sliders")
    suspend fun getSliders(): Response<ResponseSliders>
    //latest blog
    @GET("/api/v1/blogs")
    suspend fun getLatest(@Query("sortType") sortType: String): Response<ResponseLatest>
    //popular blog
    @GET("/api/v1/blogs")
    suspend fun getPopular(@Query("sortType") sortType: String): Response<ResponsePopular>
    //post detail
    @GET("/api/v1/blogs/{id}")
    suspend fun postDetail(@Path("id") id: Int): Response<ResponseDetail>
}