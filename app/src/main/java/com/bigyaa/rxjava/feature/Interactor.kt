package com.bigyaa.rxjava.feature

import android.util.Log
import com.bigyaa.rxjava.feature.main.MainPresenter
import com.bigyaa.rxjava.feature.shared.model.model.PopularMoviesP
import com.bigyaa.rxjava.feature.shared.model.model.ResultMovies
import com.bigyaa.rxjava.feature.shared.model.model.TopRatedMovies
import com.bigyaa.rxjava.network.ServiceBuilder
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class Interactor {
    fun getZipResults(mainPresenter: MainPresenter) {
        val popularMoviesObservale: Observable<PopularMoviesP> =
            ServiceBuilder.buildService().getMovies("c37f229b3f72e31848ae236fbd517031")

        val topRatingMovieObservable: Observable<TopRatedMovies> =
            ServiceBuilder.buildService().getTopRatedMovies("c37f229b3f72e31848ae236fbd517031")

        val result: Observable<ResultMovies> = Observable.zip(
            popularMoviesObservale.subscribeOn(Schedulers.io()),
            topRatingMovieObservable.subscribeOn(Schedulers.io()),
            object : BiFunction<PopularMoviesP, TopRatedMovies, ResultMovies> {
                override fun apply(t1: PopularMoviesP, t2: TopRatedMovies): ResultMovies {
                    val list: MutableList<ResultMovies> = ArrayList()
                    val obj = ResultMovies(t1, t2)
                    return obj
                }

            }
        )

        result.observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Observer<ResultMovies> {

                override fun onError(e: Throwable) {
                    Log.e("MainPresenter", e.message)
                    mainPresenter.view.onFailure(e)
                }

                override fun onComplete() {}

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: ResultMovies) {
                    mainPresenter.view.onResponse(t.p)
                    mainPresenter.view.onResponse2(t.t)
                }
            })
    }
}