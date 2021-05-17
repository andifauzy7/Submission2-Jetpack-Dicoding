package com.example.cinema.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cinema.data.api.ApiConfig
import com.example.cinema.data.response.*
import com.example.cinema.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {

    fun getMoviesPopular() : MutableLiveData<Resource<List<ResultMovies>>>{
        val movies = MutableLiveData<Resource<List<ResultMovies>>>()
        val clients = ApiConfig.getApiService().getMoviesPopular()
        clients.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(
                    call: Call<ResponseMovie>,
                    response: Response<ResponseMovie>
            ) {
                if(response.isSuccessful) {
                    val result : List<ResultMovies> = response.body()!!.results
                    movies.postValue(Resource.success(result))
                } else {
                    movies.postValue(Resource.error(response.message().toString(), emptyList()))
                    Log.e("MainViewModel", "onFailure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                movies.postValue(Resource.error(t.message.toString(), emptyList()))
                Log.e("MainViewModel", "onFailure: ${t.message.toString()}")
            }
        })
        return movies
    }

    fun getTVShowPopular() : MutableLiveData<Resource<List<ResultTVShow>>>{
        val tvShow = MutableLiveData<Resource<List<ResultTVShow>>>()
        val clients = ApiConfig.getApiService().getTVShowPopular()
        clients.enqueue(object : Callback<ResponseTVShow> {
            override fun onResponse(
                    call: Call<ResponseTVShow>,
                    response: Response<ResponseTVShow>
            ) {
                if(response.isSuccessful) {
                    val result : List<ResultTVShow> = response.body()!!.results
                    tvShow.postValue(Resource.success(result))
                } else {
                    tvShow.postValue(Resource.error(response.message().toString(), emptyList()))
                    Log.e("MainViewModel", "onFailure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ResponseTVShow>, t: Throwable) {
                tvShow.postValue(Resource.error(t.message.toString(), emptyList()))
                Log.e("MainViewModel", "onFailure : ${t.message.toString()}")
            }
        })
        return tvShow
    }

    fun getMoviesSearch(keyword : String) : MutableLiveData<Resource<List<ResultMovies>>>{
        val movies = MutableLiveData<Resource<List<ResultMovies>>>()
        val clients = ApiConfig.getApiService().getMoviesSearch(keyword)
        clients.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(
                    call: Call<ResponseMovie>,
                    response: Response<ResponseMovie>
            ) {
                if (response.isSuccessful) {
                    val result : List<ResultMovies> = response.body()!!.results
                    movies.postValue(Resource.success(result))
                } else {
                    movies.postValue(Resource.error(response.message().toString(), emptyList()))
                    Log.e("MainViewModel", "onFailure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                movies.postValue(Resource.error(t.message.toString(), emptyList()))
                Log.e("MainViewModel", "onFailure: ${t.message.toString()}")
            }
        })
        return movies
    }

    fun getShowSearch(keyword : String) : MutableLiveData<Resource<List<ResultTVShow>>>{
        val show = MutableLiveData<Resource<List<ResultTVShow>>>()
        val clients = ApiConfig.getApiService().getShowSearch(keyword)
        clients.enqueue(object : Callback<ResponseTVShow> {
            override fun onResponse(
                    call: Call<ResponseTVShow>,
                    response: Response<ResponseTVShow>
            ) {
                if (response.isSuccessful) {
                    val result : List<ResultTVShow> = response.body()!!.results
                    show.postValue(Resource.success(result))
                } else {
                    show.postValue(Resource.error(response.message().toString(), emptyList()))
                    Log.e("MainViewModel", "onFailure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ResponseTVShow>, t: Throwable) {
                show.postValue(Resource.error(t.message.toString(), emptyList()))
                Log.e("MainViewModel", "onFailure: ${t.message.toString()}")
            }
        })
        return show
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