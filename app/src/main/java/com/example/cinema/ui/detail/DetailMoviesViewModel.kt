package com.example.cinema.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.MovieRepository
import com.example.cinema.data.response.ResponseMovieDetail
import com.example.cinema.utils.Resource

class DetailMoviesViewModel : ViewModel() {
    fun getMovieDetail(id : String): LiveData<Resource<ResponseMovieDetail>> {
        val movieRepository = MovieRepository()
        return movieRepository.getMovieDetail(id)
    }
}