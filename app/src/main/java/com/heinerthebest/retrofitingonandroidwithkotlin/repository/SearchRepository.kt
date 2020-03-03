package com.heinerthebest.retrofitingonandroidwithkotlin.repository

import com.heinerthebest.retrofitingonandroidwithkotlin.api.GithubApiService
import com.heinerthebest.retrofitingonandroidwithkotlin.models.domain.DummyUser
import io.reactivex.Observable
import com.heinerthebest.retrofitingonandroidwithkotlin.models.domain.Result

class SearchRepository(private val apiService: GithubApiService) {
    fun searchUsers(location: String, language: String): Observable<Result> {
        return apiService.search(query = "location:$location+language:$language")
    }
    fun searchDummyUsers(): Observable<List<DummyUser>> {
        return apiService.searchDummyUsers()
    }
}