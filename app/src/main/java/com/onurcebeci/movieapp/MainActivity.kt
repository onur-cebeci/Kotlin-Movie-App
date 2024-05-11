package com.onurcebeci.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.onurcebeci.movieapp.navigation.BannerScreen
import com.onurcebeci.movieapp.navigation.Navigation
import com.onurcebeci.movieapp.ui.theme.MovieAppTheme
import com.onurcebeci.movieapp.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val movieViewModel = viewModel<MovieViewModel>()
                    val state = movieViewModel.state

                 //   Text(text = state.movies.toString())

                            Navigation()

                }
            }
        }
    }
}

