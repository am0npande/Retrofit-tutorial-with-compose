package com.example.retrofitcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.retrofitcompose.Screens.ListpageScreen
import com.example.retrofitcompose.Screens.MultipleQueryPageScreen
import com.example.retrofitcompose.Screens.pageNumberScreen
import com.example.retrofitcompose.Screens.pushPostScreen
import com.example.retrofitcompose.ui.theme.RetrofitComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@Suppress("DEPRECATION")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: viewmodelMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewModel.ggetPost() // Fetch data from the ViewModel

        // Observe the state and log data
        //lifecycleScope.launchWhenStarted {
//            viewModel.postResponse.collect { post ->
//                if (post != null) {
//                    if(post.isSuccessful) {
//                        post.let{
//                            Log.d("TAGG", "Post ID: ${post.body()?.Id}")
//                            Log.d("TAGG", "Post UserID: ${post.body()?.UserId}")
//                            Log.d("TAGG", "Post Title: ${post.body()?.title}")
//                            Log.d("TAGG", "Post Body: ${post.body()?.body}")
//                        }
//                    }
//                    else{
//                        Log.d("TAGG","Error 404 page not found")
//                    }
//                }
//            }
        //}

        setContent {
            RetrofitComposeTheme {
                // Your Composable content here
//                pageNumberScreen()
//                ListpageScreen()
//                MultipleQueryPageScreen()
                pushPostScreen()
            }
        }
    }
}