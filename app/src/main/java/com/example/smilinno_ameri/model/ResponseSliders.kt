package com.example.smilinno_ameri.model


import com.google.gson.annotations.SerializedName

class ResponseSliders : ArrayList<ResponseSliders.ResponseSlidersItem>(){
    data class ResponseSlidersItem(
        @SerializedName("id")
        val id: Int?, // 1
        @SerializedName("path")
        val path: String?, // http://94.101.179.76:4005/blog1.jpg
        @SerializedName("title")
        val title: String? // Novak Djokovic battles past Daniil Medvedev at ATP Finals
    )
}