package com.onurcebeci.movieapp.domain


import com.onurcebeci.movieapp.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movies?")
    suspend fun  getMovies(
  @Query("page")page: Int

    ):Response<MoviesList>

}