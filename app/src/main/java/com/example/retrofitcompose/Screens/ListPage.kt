package com.example.retrofitcompose.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.retrofitcompose.viewmodelMain
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun ListpageScreen(viewModel: viewmodelMain = hiltViewModel()){
    var userid by remember { mutableStateOf("") }
    val postResponse by viewModel.postResponseList.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(all = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        TextField(value = userid, onValueChange = {
            userid = it}
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val useridInt = userid.toIntOrNull()
            if (useridInt != null) {
                viewModel.ggetPostList(useridInt)
            } else {
                // Handle the case where the input is not a valid userid
                println("Invalid userid entered")
            }
        }) {
            Text("GET")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            postResponse?.let { response ->
                if (response.isSuccessful) {
                    response.body()?.forEach { post ->
                        Text(text = "Post ID: ${post.Id}")
                        Text(text = "User ID: ${post.UserId}")
                        Text(text = "Title: ${post.title}")
                        Text(text = "Body: ${post.body}")
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                } else {
                    Text(text = "Error: ${response.errorBody()?.string()}")
                }
            }
        }



    }

}