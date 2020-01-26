package com.dimas.moviecatalague

import android.os.Bundle
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        setActionBarTitle(movie.name)

        img_detail_movie.outlineProvider = ViewOutlineProvider.BACKGROUND
        img_detail_movie.clipToOutline = true
        img_detail_movie.setImageResource(movie.photo)
        txt_detail_name.text = movie.name
        txt_detail_release.text = movie.date
        txt_detail_description.text = movie.description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setActionBarTitle(title: String) {
        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.title = title
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }
}
