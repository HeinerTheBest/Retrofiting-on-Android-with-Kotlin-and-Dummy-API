package com.heinerthebest.retrofitingonandroidwithkotlin.repository

import com.heinerthebest.retrofitingonandroidwithkotlin.api.GithubApiService

object SearchRepositoryProvider {

    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(GithubApiService.create())
    }

    fun provideSearchDummyRepository(): SearchRepository {
        return SearchRepository(GithubApiService.createDummy())
    }
}