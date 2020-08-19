package com.bigyaa.rxjava.feature.shared.model.model

data class TopRatedMovies(
    val results: List<ResultP>
)

data class ResultP(
//    val id: Int,
//    val name: String
//    val overview: String,
    val poster_path: String
//    val vote_average: Double
)