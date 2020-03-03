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

data class DummyUser(
    val id: Long,
    val name: String,
    val userName: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipCode: String,
    val geo: Geo
)

data class Geo(
    val lat: Double,
    val lng: Double
)

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class Result(val total_count: Int, val incomplete_results: Boolean, val items: List<User>)

data class DummyResult(val items: List<DummyUser>)