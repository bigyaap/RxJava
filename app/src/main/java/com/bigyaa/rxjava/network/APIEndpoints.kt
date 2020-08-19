package com.bigyaa.rxjava.network

import com.bigyaa.rxjava.feature.shared.model.model.PopularMoviesP
import com.bigyaa.rxjava.feature.shared.model.model.TopRatedMovies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIEndpoints {

    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") key: String): Observable<PopularMoviesP>

    @GET("/3/tv/top_rated")
    fun getTopRatedMovies(@Query("api_key") key: String): Observable<TopRatedMovies>
}
