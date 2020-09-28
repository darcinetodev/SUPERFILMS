package com.example.superfilms.model

import com.google.gson.annotations.SerializedName

class Film (
    @SerializedName("page")
    val page : Int,
    @SerializedName("total_pages")
    val totalPages : Int,
    @SerializedName("total_results")
    val totalResults : Int,
    @SerializedName("results")
    val results : List<Results>,
    @SerializedName("dates")
    val dates : Dates
)

class Results (
    @SerializedName("poster_path")
    val posterPath : String?,
    @SerializedName("adult")
    val adult : Boolean,
    @SerializedName("overview")
    val overview : String,
    @SerializedName("release_date")
    val releaseDate : String,
    @SerializedName("genre_idsarray")
    val genreIdsarray : Int,
    @SerializedName("id")
    val id : Int,
    @SerializedName("original_title")
    val originalTitle : String,
    @SerializedName("original_language")
    val originalLanguage : String,
    @SerializedName("title")
    val title : String,
    @SerializedName("backdrop_path")
    val backdropPath : String?,
    @SerializedName("popularity")
    val popularity : Double,
    @SerializedName("vote_count")
    val voteCount : Int,
    @SerializedName("video")
    val video : Boolean,
    @SerializedName("vote_average")
    val voteAverage : Double
)

class Dates (
    @SerializedName("maximum")
    val maximum : String,
    @SerializedName("minimum")
    val minimum : String
)