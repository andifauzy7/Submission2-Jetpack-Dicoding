package com.example.cinema.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinema.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
            val moviesAdapterPopular = MoviesAdapter()
            fragmentHomeBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMoviesPopular().observe(viewLifecycleOwner,{movies ->
                fragmentHomeBinding.progressBar.visibility = View.GONE
                moviesAdapterPopular.setMovies(movies)
                moviesAdapterPopular.notifyDataSetChanged()
            })

            with(fragmentHomeBinding.rvPopular) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = moviesAdapterPopular
            }

            val moviesAdapterNowPlaying = MoviesAdapter()
            fragmentHomeBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMoviesNowPlaying().observe(viewLifecycleOwner,{movies ->
                fragmentHomeBinding.progressBar.visibility = View.GONE
                moviesAdapterNowPlaying.setMovies(movies)
                moviesAdapterNowPlaying.notifyDataSetChanged()
            })

            with(fragmentHomeBinding.rvNowPlaying) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = moviesAdapterNowPlaying
            }

            val moviesAdapterUpComing = MoviesAdapter()
            fragmentHomeBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMoviesUpComing().observe(viewLifecycleOwner,{movies ->
                fragmentHomeBinding.progressBar.visibility = View.GONE
                moviesAdapterUpComing.setMovies(movies)
                moviesAdapterUpComing.notifyDataSetChanged()
            })

            with(fragmentHomeBinding.rvUpcoming) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = moviesAdapterUpComing
            }
        }
    }
}