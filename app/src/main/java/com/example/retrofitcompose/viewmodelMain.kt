package com.example.retrofitcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcompose.model.PostClass
import com.example.retrofitcompose.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class viewmodelMain @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    private val _postResponse = MutableStateFlow<Response<PostClass>?>(null)
    val postResponse: MutableStateFlow<Response<PostClass>?> = _postResponse

    private val _postResponseList = MutableStateFlow<Response<List<PostClass>>?>(null)
    val postResponseList: MutableStateFlow<Response<List<PostClass>>?> = _postResponseList

    fun ggetPost(){
        viewModelScope.launch {
            val response: Response<PostClass> = repository.GetPost()
            _postResponse.value = response
        }
    }
    fun ggetPost(number: Int){
        viewModelScope.launch {
            val response : Response<PostClass> = repository.GetPost2(number)
            _postResponse.value = response


        }
    }
    fun ggetPostList(userid: Int){
        viewModelScope.launch {
            val response : Response<List<PostClass>> = repository.GetPostList(userid)
            _postResponseList.value = response


        }
    }
    fun ggetPostMultipleQuery(userid: Int,options:Map<String,String>){
        viewModelScope.launch {
            val response : Response<List<PostClass>> = repository.GetMutipleQuery(userid,options)
            _postResponseList.value = response

        }
    }

    fun ppushPost(post:PostClass){
        viewModelScope.launch {
            val response = repository.PushPost(post)
            _postResponse.value = response
        }
    }
}