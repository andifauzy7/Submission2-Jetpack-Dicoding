package com.example.cinema.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.MovieRepository
import com.example.cinema.data.response.ResponseTVShowDetail
import com.example.cinema.utils.Resource

class DetailTVShowViewModel : ViewModel() {
    fun getTVShowDetail(id : String): LiveData<Resource<ResponseTVShowDetail>> {
        val movieRepository = MovieRepository()
        return movieRepository.getTVShowDetail(id)
    }
}