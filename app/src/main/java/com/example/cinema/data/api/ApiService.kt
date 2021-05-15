package com.example.cinema.data.api

import com.example.cinema.data.response.ResponseMovie
import com.example.cinema.data.response.ResponseMovieDetail
import com.example.cinema.data.response.ResponseMovieReview
import com.example.cinema.data.response.ResponseTVShow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("tv/popular?api_key=${ApiConfig.ApiKey}")
    fun getTVShowPopular() : Call<ResponseTVShow>

    @GET("movie/upcoming?api_key=${ApiConfig.ApiKey}")
    fun getMoviesUpComing() : Call<ResponseMovie>

    @GET("movie/popular?api_key=${ApiConfig.ApiKey}")
    fun getMoviesPopular() : Call<ResponseMovie>

    @GET("movie/now_playing?api_key=${ApiConfig.ApiKey}")
    fun getMoviesNowPlaying() : Call<ResponseMovie>

    @GET("movie/{movie_id}?api_key=${ApiConfig.ApiKey}")
    fun getMovieDetail(@Path("movie_id") id: String): Call<ResponseMovieDetail>

    @GET("movie/{movie_id}/reviews?api_key=${ApiConfig.ApiKey}")
    fun getMovieReview(@Path("movie_id") id: String): Call<ResponseMovieReview>
}