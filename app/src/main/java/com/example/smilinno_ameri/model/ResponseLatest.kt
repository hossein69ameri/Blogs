package com.example.smilinno_ameri.model


import com.google.gson.annotations.SerializedName

class ResponseLatest : ArrayList<ResponseLatest.ResponseLatestItem>(){
    data class ResponseLatestItem(
        @SerializedName("date")
        val date: String?, // 2022-11-22T14:24:18
        @SerializedName("id")
        val id: Int?, // 3
        @SerializedName("path")
        val path: String?, // http://94.101.179.76:4005/blog3.jpg
        @SerializedName("title")
        val title: String? // The damned World Cup kicks off and Qatar is not in any mood to apologise
    )
}