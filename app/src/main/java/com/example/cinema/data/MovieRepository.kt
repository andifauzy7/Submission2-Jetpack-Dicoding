package com.example.cinema.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cinema.data.api.ApiConfig
import com.example.cinema.data.response.ResponseMovie
import com.example.cinema.data.response.ResponseMovieDetail
import com.example.cinema.data.response.ResponseMovieReview
import com.example.cinema.data.response.ResultMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {

    fun getMoviesUpComing() : MutableLiveData<List<ResultMovies>> {
        val movies = MutableLiveData<List<ResultMovies>>()
        val clients = ApiConfig.getApiService().getMoviesUpComing()
        clients.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(
                call: Call<ResponseMovie>,
                response: Response<ResponseMovie>
            ) {
                if(response.isSuccessful) {
                    movies.postValue(response.body()?.results)
                } else {
                    Log.e("MainViewModel", "onFailure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                Log.e("MainViewModel", "onFailure: ${t.message.toString()}")
            }
        })
        return movies
    }

    fun getMoviesPopular() : MutableLiveData<List<ResultMovies>>{
        val movies = MutableLiveData<List<ResultMovies>>()
        val clients = ApiConfig.getApiService().getMoviesPopular()
        clients.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(
                call: Call<ResponseMovie>,
                response: Response<ResponseMovie>
            ) {
                if(response.isSuccessful) {
                    movies.postValue(response.body()?.results)
                } else {
                    Log.e("MainViewModel", "onFailure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                Log.e("MainViewModel", "onFailure: ${t.message.toString()}")
            }
        })
        return movies
    }

    fun getMoviesNowPlaying() : MutableLiveData<List<ResultMovies>>{
        val movies = MutableLiveData<List<ResultMovies>>()
        val clients = ApiConfig.getApiService().getMoviesNowPlaying()
        clients.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(
                call: Call<ResponseMovie>,
                response: Response<ResponseMovie>
            ) {
                if(response.isSuccessful) {
                    movies.postValue(response.body()?.results)
                } else {
                    Log.e("MainViewModel", "onFailure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                Log.e("MainViewModel", "onFailure: ${t.message.toString()}")
            }
        })
        return movies
    }

    fun getMovieDetail(movieId: String){
        val clients = ApiConfig.getApiService().getMovieDetail(movieId)
        clients.enqueue(object : Callback<ResponseMovieDetail> {
            override fun onResponse(
                call: Call<ResponseMovieDetail>,
                response: Response<ResponseMovieDetail>
            ) {
                // Jika sukses.
            }
            override fun onFailure(call: Call<ResponseMovieDetail>, t: Throwable) {
                // Jika gagal.
            }
        })
    }

    fun getMovieReview(movieId: String){
        val clients = ApiConfig.getApiService().getMovieReview(movieId)
        clients.enqueue(object : Callback<ResponseMovieReview> {
            override fun onResponse(
                call: Call<ResponseMovieReview>,
                response: Response<ResponseMovieReview>
            ) {
                // Jika sukses.
            }
            override fun onFailure(call: Call<ResponseMovieReview>, t: Throwable) {
                // Jika gagal.
            }
        })
    }
}