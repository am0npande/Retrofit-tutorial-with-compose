package com.example.retrofitcompose.Screens

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
import com.example.retrofitcompose.viewmodelMain
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MultipleQueryPageScreen(viewModel: viewmodelMain = hiltViewModel()){
    var number by remember { mutableStateOf("") }
    val postResponse by viewModel.postResponseList.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        TextField(value = number, onValueChange = {
            number = it}
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val numberInt = number.toIntOrNull()
            val hasMap :HashMap<String,String> = HashMap()
            hasMap["_sort"] = "id"
            hasMap["_order"] = "desc"
            if (numberInt != null) {
                viewModel.ggetPostMultipleQuery(numberInt,hasMap)
            } else {
                // Handle the case where the input is not a valid number
                println("Invalid number entered")
            }
        }) {
            Text("GET")
        }

        Spacer(modifier = Modifier.height(20.dp))

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