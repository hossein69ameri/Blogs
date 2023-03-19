package com.example.smilinno_ameri.data.network

import com.example.smilinno_ameri.model.ResponseSliders
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

@GET("/api/v1/sliders")
suspend fun getSliders() : Response<ResponseSliders>

}