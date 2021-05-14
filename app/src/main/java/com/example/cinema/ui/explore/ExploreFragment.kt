package com.example.cinema.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cinema.R

class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        exploreViewModel =
                ViewModelProvider(this).get(ExploreViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_explore, container, false)
        val textView: TextView = root.findViewById(R.id.text_explore)
        exploreViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}