package com.onurcebeci.movieapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onurcebeci.movieapp.models.Data
import kotlinx.coroutines.launch

class MovieViewModel  : ViewModel(){

    private  val repository = Respository()

    var state by mutableStateOf(ScreenState())
    init{
viewModelScope.launch {
    val response = repository.getMovieList(state.page)

          state = state.copy(

              movies =  response.body()!!.data
          )
        }
    }





}

data class  ScreenState(

    val movies: List<Data> = emptyList(),

    val page: Int = 1

)