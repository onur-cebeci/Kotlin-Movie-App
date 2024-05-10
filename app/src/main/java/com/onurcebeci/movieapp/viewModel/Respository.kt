package com.onurcebeci.movieapp.viewModel

import RetrofitInstance
import com.onurcebeci.movieapp.models.MoviesList
import retrofit2.Response

class Respository {
    suspend fun  getMovieList(page:Int):Response<MoviesList>{

        return  RetrofitInstance.api.getMovies(page)
    }
}