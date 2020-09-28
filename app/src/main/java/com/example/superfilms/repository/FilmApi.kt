package com.example.superfilms.repository

import com.example.superfilms.model.Film
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApi {

    @GET("movie/now_playing")
    fun getAllFilms(@Query("api_key") apiKey: String): Call<Film>

}