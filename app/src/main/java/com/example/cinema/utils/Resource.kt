package com.example.cinema.utils

import androidx.annotation.Nullable
import com.example.cinema.data.response.ResultMovies


class Resource<T> private constructor(val status: Status, @field:Nullable @param:Nullable var data: T,
                                      @field:Nullable @param:Nullable val message: String?) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String?, @Nullable data: T): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}