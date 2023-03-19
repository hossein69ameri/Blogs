package com.example.smilinno_ameri.util

import retrofit2.Response

open class NetworkResponseCode<T>(private val response: Response<T>) {

    fun generalNetworkResponse(): NetworkResult<T> {
        return when {
            response.code() in 400..499 -> NetworkResult.Error("Error")
            response.code() in 500..599 -> NetworkResult.Error("Error")
            response.isSuccessful -> NetworkResult.Success(response.body()!!)
            else -> NetworkResult.Error("Error")
        }
    }
}