package com.bigyaa.rxjava.feature.main

import com.bigyaa.rxjava.feature.shared.model.model.PopularMoviesP
import com.bigyaa.rxjava.feature.shared.model.model.TopRatedMovies
import com.hannesdorfmann.mosby3.mvp.MvpView

interface MainView : MvpView {
    fun onFailure(t: Throwable)
    fun onResponse(response: PopularMoviesP)
    fun onResponse2(response: TopRatedMovies)
}