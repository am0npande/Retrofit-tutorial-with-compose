package com.example.retrofitcompose.Screens

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.retrofitcompose.model.PostClass
import com.example.retrofitcompose.viewmodelMain
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun pushPostScreen(viewModel: viewmodelMain = hiltViewModel()){

    var number by remember { mutableStateOf("") }
    val postResponse by viewModel.postResponse.collectAsState()

    val posts = PostClass(2,2,"aman pandey","fresher Android Developer")
    viewModel.ppushPost(posts)
    var hasLoggedResponse by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        postResponse?.let {post->
            if(post.isSuccessful){
                Text(text = post.toString())
                Log.d("TAGG",post.body().toString())
                Log.d("TAGG",post.code().toString())  //201 code means post is successful and led to the creation of resource
                Log.d("TAGG",post.message())
                hasLoggedResponse = true
            }
            else{
                Text(text = post.errorBody().toString())
                hasLoggedResponse = true
            }
        }
    }
}