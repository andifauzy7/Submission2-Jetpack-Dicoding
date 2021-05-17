package com.example.cinema.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cinema.databinding.FragmentExploreBinding
import com.example.cinema.utils.Resource

class ExploreFragment : Fragment() {
    private lateinit var fragmentExploreBinding: FragmentExploreBinding
    private lateinit var exploreViewModel: ExploreViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentExploreBinding = FragmentExploreBinding.inflate(layoutInflater, container, false)
        return fragmentExploreBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exploreViewModel = ViewModelProvider(this).get(ExploreViewModel::class.java)

        fragmentExploreBinding.searchItemExplore.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                fragmentExploreBinding.searchItemExplore.onActionViewCollapsed()
                if(fragmentExploreBinding.radioGroupTypeExplore.checkedRadioButtonId == fragmentExploreBinding.moviesButtonExplore.id){
                    exploreViewModel.getMoviesSearch(query.toString()).observe(viewLifecycleOwner, { movies ->
                        if (movies.status == Resource.Status.SUCCESS) {
                            Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
                        }
                        else if (movies.status == Resource.Status.ERROR) {
                            Toast.makeText(context, "Error : " + movies.message, Toast.LENGTH_LONG).show()
                        }
                    })
                } else {
                    exploreViewModel.getShowSearch(query.toString()).observe(viewLifecycleOwner, { show ->
                        if (show.status == Resource.Status.SUCCESS) {
                            Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
                        }
                        else if (show.status == Resource.Status.ERROR) {
                            Toast.makeText(context, "Error : " + show.message, Toast.LENGTH_LONG).show()
                        }
                    })
                }
                //fragmentExploreBinding.radioGroupTypeExplore.checkedRadioButtonId

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
}