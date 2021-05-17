package com.example.cinema.ui.explore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.R
import com.example.cinema.data.response.ResultTVShow
import com.example.cinema.databinding.ItemTvshowExploreBinding

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {
    private var listTVShow = ArrayList<ResultTVShow>()

    fun setShow(tvShow: List<ResultTVShow>){
        this.listTVShow.clear()
        this.listTVShow.addAll(tvShow)
    }

    class TVShowViewHolder(private val binding: ItemTvshowExploreBinding) : RecyclerView.ViewHolder(binding.root) {
        @Suppress("UselessCallOnNotNull")
        fun bind(tvShow : ResultTVShow){
            with(binding){
                if(tvShow.posterPath.isNullOrEmpty()){
                    Glide.with(itemView.context)
                            .load(R.drawable.thumbnail)
                            .into(imgTvshowExplore)
                } else {
                    Glide.with(itemView.context)
                            .load("http://image.tmdb.org/t/p/w500" + tvShow.posterPath)
                            .into(imgTvshowExplore)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val itemTvShowBinding = ItemTvshowExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(itemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvShow = listTVShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTVShow.size
}