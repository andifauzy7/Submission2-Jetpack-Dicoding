package com.example.cinema.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.cinema.databinding.FragmentDetailMoviesBinding
import com.example.cinema.utils.Resource

class DetailMoviesFragment(idContent: String?) : Fragment() {
    private var idContent : String = idContent.toString()
    private lateinit var viewModel: DetailMoviesViewModel
    private lateinit var fragmentDetailMoviesBinding: FragmentDetailMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        fragmentDetailMoviesBinding = FragmentDetailMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentDetailMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailMoviesViewModel::class.java)
        fragmentDetailMoviesBinding.progressBarMovieDetail.visibility = View.VISIBLE
        viewModel.getMovieDetail(idContent).observe(viewLifecycleOwner, { movies ->
            if (movies.status == Resource.Status.SUCCESS) {
                fragmentDetailMoviesBinding.progressBarMovieDetail.visibility = View.GONE
                context?.let {
                    Glide.with(it)
                            .load("https://image.tmdb.org/t/p/w500" + movies.data?.posterPath)
                            .centerCrop()
                            .transform(RoundedCorners(16))
                            .into(fragmentDetailMoviesBinding.imgDetailMovies)
                }
                fragmentDetailMoviesBinding.tvTitleMovies.text = movies.data?.title
                fragmentDetailMoviesBinding.tvBudgetMovies.text = movies.data?.budget.toString()
                var genre = ""
                for (i in movies.data?.genres!!){
                    genre += i.name + ", "
                }
                fragmentDetailMoviesBinding.tvGenreMovies.text = genre
                fragmentDetailMoviesBinding.ratingBarMovies.rating = (movies.data?.voteAverage?.div(2))?.toFloat()!!
                fragmentDetailMoviesBinding.tvReleasedMovies.text = movies.data?.releaseDate
                fragmentDetailMoviesBinding.tvHomepageMovies.text = movies.data?.homepage
                fragmentDetailMoviesBinding.tvOverviewMovies.text = movies.data?.overview
            }
            else if (movies.status == Resource.Status.ERROR) {
                fragmentDetailMoviesBinding.progressBarMovieDetail.visibility = View.GONE
                Toast.makeText(context, "Error : " + movies.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}