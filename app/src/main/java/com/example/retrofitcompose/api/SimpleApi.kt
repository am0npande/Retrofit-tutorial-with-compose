package com.example.retrofitcompose.api

import com.example.retrofitcompose.model.PostClass
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {

    @GET("/posts/1")
    suspend fun getPost():Response<PostClass>

    //Response handles error if endpoint is typed wrong

    @GET("/posts/{pageNumber}")
    suspend fun getPost2(
        @Path("pageNumber")number:Int
    ):Response<PostClass>

    @GET("posts")
    suspend fun getPost2List(
        @Query("userId") USERID: Int
    ):Response<List<PostClass>>

    @GET("posts")
    suspend fun getMultipleQueryPost(
        @Query("userId") USERID:Int,
        @QueryMap options:Map<String,String>
    ):Response<List<PostClass>>

    //post request used to send data in  server and to update data in server

    //request made with annotation will have application/x-www-form-urlencoded MIME type instead of JSON

    @POST("posts")
    suspend fun pushPost(
        @Body post:PostClass
    ):Response<PostClass>
}