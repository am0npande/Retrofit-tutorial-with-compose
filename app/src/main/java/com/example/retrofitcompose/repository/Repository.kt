package com.example.retrofitcompose.repository

import com.example.retrofitcompose.api.SimpleApi
import com.example.retrofitcompose.model.PostClass
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

//making api lazy while using hilt together.........
class Repository @Inject constructor(
    private val api: SimpleApi
) {
    suspend fun GetPost(): Response<PostClass> {
        return api.getPost()
    }
    suspend fun GetPost2(number:Int):Response<PostClass>{
        return api.getPost2(number)
    }
    suspend fun GetPostList(userid:Int):Response<List<PostClass>>{
        return api.getPost2List(userid)
    }
    suspend fun GetMutipleQuery(userID:Int,options:Map<String,String>):Response<List<PostClass>>{
        return api.getMultipleQueryPost(userID,options)
    }
    suspend fun PushPost(post:PostClass): Response<PostClass> {
        return api.pushPost(post)
    }
}