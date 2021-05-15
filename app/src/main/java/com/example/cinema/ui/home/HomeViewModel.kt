package com.example.cinema.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.MovieRepository
import com.example.cinema.data.response.ResultMovies

class HomeViewModel : ViewModel() {

    fun getMoviesPopular(): LiveData<List<ResultMovies>> {
        val movieRepository = MovieRepository()
        return movieRepository.getMoviesPopular()
    }
}