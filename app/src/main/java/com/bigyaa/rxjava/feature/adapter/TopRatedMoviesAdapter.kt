package com.bigyaa.rxjava.feature.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bigyaa.rxjava.R
import com.bigyaa.rxjava.feature.model.ResultP
//import com.bigyaa.rxjava.feature.model.Result
import com.bumptech.glide.Glide

class TopRatedMoviesAdapter(val movies: List<ResultP>) :
    RecyclerView.Adapter<TopRatedMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.toprated_movie_item, parent, false)
        return TopRatedMoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: TopRatedMoviesViewHolder, position: Int) {
        return holder.bind(movies[position])
    }
}

class TopRatedMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val photo: ImageView = itemView.findViewById(R.id.imgTopMoviePhoto)
//    private val name: TextView = itemView.findViewById(R.id.movie_title)
//    private val overview: TextView = itemView.findViewById(R.id.movie_overview)
//    private val popularity: TextView = itemView.findViewById(R.id.movie_rating)

    fun bind(movie: ResultP) {
        Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${movie.poster_path}")
            .into(photo)
//        name.text = "Title: " + movie.title
//        overview.text = movie.overview
//        popularity.text = "Rating : " + movie.vote_average.toString()
    }
}