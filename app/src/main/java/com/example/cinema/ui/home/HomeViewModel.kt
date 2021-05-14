package com.example.cinema.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.api.ApiConfig
import com.example.cinema.data.response.ResponseMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Home Fragment"
    }
    val text: LiveData<String> = _text

    fun getMoviesUpComing(){
        val clients = ApiConfig.getApiService().getMoviesUpComing()
        clients.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(
                call: Call<ResponseMovie>,
                response: Response<ResponseMovie>
            ) {
                // Jika sukses.
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                // Jika gagal.
            }
        })
    }

    fun getMoviesPopular(){
        val clients = ApiConfig.getApiService().getMoviesPopular()
        clients.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(
                call: Call<ResponseMovie>,
                response: Response<ResponseMovie>
            ) {
                // Jika sukses.
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                // Jika gagal.
            }
        })
    }

    fun getMoviesNowPlaying(){
        val clients = ApiConfig.getApiService().getMoviesNowPlaying()
        clients.enqueue(object : Callback<ResponseMovie> {
            override fun onResponse(
                call: Call<ResponseMovie>,
                response: Response<ResponseMovie>
            ) {
                // Jika sukses.
            }
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                // Jika gagal.
            }
        })
    }
}