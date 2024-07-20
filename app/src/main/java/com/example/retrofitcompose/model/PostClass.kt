package com.example.retrofitcompose.model

import com.google.gson.annotations.SerializedName

data class PostClass(

    @SerializedName("userId")
    val UserId:Int,
    @SerializedName("id")
    val Id:Int,
    val title:String,
    val body:String
)