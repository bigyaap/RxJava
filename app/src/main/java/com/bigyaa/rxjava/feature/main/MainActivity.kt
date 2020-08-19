package com.bigyaa.rxjava.feature.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigyaa.rxjava.R
import com.bigyaa.rxjava.feature.adapter.PopularMoviesAdapter
import com.bigyaa.rxjava.feature.adapter.TopRatedMoviesAdapter
import com.bigyaa.rxjava.feature.model.PopularMoviesP
import com.bigyaa.rxjava.feature.model.TopRatedMovies
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_main_multiple.*

class MainActivity : MvpActivity<MainView, MainPresenter>(),
    MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_multiple)
        presenter.zip()
    }

    override fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(response: PopularMoviesP) {
        progressbar.visibility = View.GONE
        recyclerView1.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter =
                PopularMoviesAdapter(response.results)
        }
    }

    override fun onResponse2(response: TopRatedMovies) {
        recyclerView2.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter =
                TopRatedMoviesAdapter(response.results)
        }
    }

    override fun createPresenter() = MainPresenter(this)

}
