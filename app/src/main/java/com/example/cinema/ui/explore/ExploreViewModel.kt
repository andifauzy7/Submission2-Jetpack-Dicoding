package com.example.cinema.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.MovieRepository
import com.example.cinema.data.response.ResultMovies
import com.example.cinema.data.response.ResultTVShow
import com.example.cinema.utils.Resource

class ExploreViewModel : ViewModel() {
    fun getMoviesSearch(keyword : String): LiveData<Resource<List<ResultMovies>>> {
        val movieRepository = MovieRepository()
        return movieRepository.getMoviesSearch(keyword)
    }

    fun getShowSearch(keyword : String): LiveData<Resource<List<ResultTVShow>>> {
        val movieRepository = MovieRepository()
        return movieRepository.getShowSearch(keyword)
    }
}