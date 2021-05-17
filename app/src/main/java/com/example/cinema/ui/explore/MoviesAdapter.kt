package com.example.cinema.ui.explore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.R
import com.example.cinema.data.response.ResultMovies
import com.example.cinema.databinding.ItemMoviesExploreBinding

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){
    private var listMovies = ArrayList<ResultMovies>()

    class MoviesViewHolder(private val binding: ItemMoviesExploreBinding) : RecyclerView.ViewHolder(binding.root){
        @Suppress("UselessCallOnNotNull")
        fun bind(movies : ResultMovies){
            with(binding){
                if(movies.posterPath.isNullOrEmpty()){
                    Glide.with(itemView.context)
                            .load(R.drawable.thumbnail)
                            .into(imgMoviesExplore)
                } else {
                    Glide.with(itemView.context)
                            .load("http://image.tmdb.org/t/p/w500" + movies.posterPath)
                            .into(imgMoviesExplore)
                }
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
        val itemsMoviesBinding = ItemMoviesExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size
}