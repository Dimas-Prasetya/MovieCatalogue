package com.dimas.moviecatalague

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDate: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MovieAdapter(this)
        lv_list.adapter = adapter

        prepare()
        addItem()

        lv_list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val moveWithMovieData = Intent(this@MainActivity, DetailMovieActivity::class.java)
            moveWithMovieData.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.get(position))
            startActivity(moveWithMovieData)
        }

    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDate = resources.getStringArray(R.array.data_release_date)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val movie = Movie(
                dataName[position],
                dataDate[position],
                dataDescription[position],
                dataPhoto.getResourceId(position, -1)
            )

            movies.add(movie)
        }
        adapter.movies = movies
    }
}
