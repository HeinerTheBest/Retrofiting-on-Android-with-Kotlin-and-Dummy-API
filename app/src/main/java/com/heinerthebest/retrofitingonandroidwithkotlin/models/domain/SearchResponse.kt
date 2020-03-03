package com.heinerthebest.retrofitingonandroidwithkotlin.models.domain

import com.google.gson.annotations.SerializedName

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
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("username") val username : String,
    @SerializedName("email") val email : String,
    @SerializedName("address") val address : Address,
    @SerializedName("phone") val phone : String,
    @SerializedName("website") val website : String,
    @SerializedName("company") val company : Company
)

data class Address(
    @SerializedName("street") val street : String,
    @SerializedName("suite") val suite : String,
    @SerializedName("city") val city : String,
    @SerializedName("zipcode") val zipcode : String,
    @SerializedName("geo") val geo : Geo
)

data class Geo(
    @SerializedName("lat") val lat : Double,
    @SerializedName("lng") val lng : Double
)

data class Company(
    @SerializedName("name") val name : String,
    @SerializedName("catchPhrase") val catchPhrase : String,
    @SerializedName("bs") val bs : String
)

data class Result(val total_count: Int, val incomplete_results: Boolean, val items: List<User>)
