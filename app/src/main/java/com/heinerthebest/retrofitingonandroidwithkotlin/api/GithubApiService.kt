package com.heinerthebest.retrofitingonandroidwithkotlin.api

import android.util.Log
import com.heinerthebest.retrofitingonandroidwithkotlin.models.domain.DummyResult
import com.heinerthebest.retrofitingonandroidwithkotlin.models.domain.DummyUser
import com.heinerthebest.retrofitingonandroidwithkotlin.models.domain.Result
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TODO Add class description
 *
 * @author  heiner.bauza
 * @since 2020-02-27
 */
interface GithubApiService {

    @GET("search/users")
    fun search(@Query("q") query: String,
               @Query("page") page: Int = 1,
               @Query("per_page") perPage: Int = 20): Observable<Result>


    @GET("users")
    fun searchDummyUsers() : Observable<List<DummyUser?>>

    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): GithubApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build()

            return retrofit.create(GithubApiService::class.java)
        }


        fun createDummy(): GithubApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()

            return retrofit.create(GithubApiService::class.java)
        }
    }
}