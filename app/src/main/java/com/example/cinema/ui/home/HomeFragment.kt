package com.example.cinema.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.cinema.R
import com.example.cinema.databinding.FragmentHomeBinding
import com.example.cinema.utils.Resource


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
        Glide.with(this)
            .load(R.drawable.avatar)
            .centerCrop()
            .transform(RoundedCorners(16))
            .into(fragmentHomeBinding.profileImage)
        if (activity != null){
            viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
            val moviesAdapterPopular = MoviesAdapter()
            fragmentHomeBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMoviesPopular().observe(viewLifecycleOwner, { movies ->
                fragmentHomeBinding.progressBar.visibility = View.GONE
                if (movies.status == Resource.Status.SUCCESS) {
                    moviesAdapterPopular.setMovies(movies.data)
                    moviesAdapterPopular.notifyDataSetChanged()
                }
                else if (movies.status == Resource.Status.ERROR) {
                    Toast.makeText(context, "Error : " + movies.message, Toast.LENGTH_LONG).show()
                }
            })

            val tvShowAdapterPopular = TVShowAdapter()
            fragmentHomeBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTVShowPopular().observe(viewLifecycleOwner, { show ->
                fragmentHomeBinding.progressBar.visibility = View.GONE
                if (show.status == Resource.Status.SUCCESS) {
                    tvShowAdapterPopular.setShow(show.data)
                    tvShowAdapterPopular.notifyDataSetChanged()
                }
                else if (show.status == Resource.Status.ERROR) {
                    Toast.makeText(context, "Error : " + show.message, Toast.LENGTH_LONG).show()
                }
            })

            with(fragmentHomeBinding.rvPopular) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = moviesAdapterPopular
            }

            with(fragmentHomeBinding.rvPopularTv) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = tvShowAdapterPopular
            }

        }
    }
}