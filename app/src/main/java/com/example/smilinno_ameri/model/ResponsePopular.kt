package com.example.smilinno_ameri.model


import com.google.gson.annotations.SerializedName

class ResponsePopular : ArrayList<ResponsePopular.ResponsePopularItem>(){
    data class ResponsePopularItem(
        @SerializedName("date")
        val date: String?, // 2022-11-17T22:10:42
        @SerializedName("id")
        val id: Int?, // 2
        @SerializedName("path")
        val path: String?, // http://94.101.179.76:4005/blog2.jpg
        @SerializedName("title")
        val title: String? // Nail-biter likely as Vikings host Cowboys in crucial NFC clash
    )
}