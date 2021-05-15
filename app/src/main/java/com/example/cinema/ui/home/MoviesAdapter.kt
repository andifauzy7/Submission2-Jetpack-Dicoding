package com.example.cinema.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.data.response.ResultMovies
import com.example.cinema.databinding.ItemMoviesBinding

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){
    private var listMovies = ArrayList<ResultMovies>()

    class MoviesViewHolder(private val binding: ItemMoviesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movies : ResultMovies){
            with(binding){
                tvMoviesTitle.text = movies.title
                ratingMovies.rating = (movies.voteAverage / 2).toFloat()
                Glide.with(itemView.context)
                    .load("http://image.tmdb.org/t/p/w500" + movies.posterPath).centerCrop()
                    .into(imgMoviesPoster)
            }
        }
    }

    fun setMovies(movies: List<ResultMovies>?){
        if(movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder {
        val itemsMoviesBinding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size
}