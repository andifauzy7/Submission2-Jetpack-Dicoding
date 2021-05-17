package com.example.cinema.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cinema.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val TYPE_MOVIES = "MOVIES"
        const val TYPE_TVSHOW = "TV_SHOW"
        const val ID_CONTENT = "id_content"
        const val TYPE_CONTENT = "type_content"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailActivity = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailActivity.root)
        supportActionBar?.hide()
    }
}