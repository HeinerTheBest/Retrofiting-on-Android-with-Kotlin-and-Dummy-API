package com.heinerthebest.retrofitingonandroidwithkotlin.models.domain

/**
 * TODO Add class description
 *
 * @author  heiner.bauza
 * @since 2020-02-27
 */
data class User(
    val login: String,
    val id: Long,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val starred_url: String,
    val gists_url: String,
    val type: String,
    val score: Int
)

data class Result (val total_count: Int, val incomplete_results: Boolean, val items: List<User>)