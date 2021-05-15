package com.example.cinema.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.MovieRepository
import com.example.cinema.data.response.ResultMovies
import com.example.cinema.data.response.ResultTVShow

class HomeViewModel : ViewModel() {

    fun getMoviesPopular(): LiveData<List<ResultMovies>> {
        val movieRepository = MovieRepository()
        return movieRepository.getMoviesPopular()
    }

    fun getTVShowPopular(): LiveData<List<ResultTVShow>> {
        val movieRepository = MovieRepository()
        return movieRepository.getTVShowPopular()
    }
}