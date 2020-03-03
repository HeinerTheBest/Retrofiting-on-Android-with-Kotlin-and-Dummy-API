package com.heinerthebest.retrofitingonandroidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.heinerthebest.retrofitingonandroidwithkotlin.repository.SearchRepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val TAG = "heinerthebest007"

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = SearchRepositoryProvider.provideSearchRepository()
        val repositoryDummy = SearchRepositoryProvider.provideSearchDummyRepository()


        compositeDisposable.add(
            repository.searchUsers("Lagos", "Java")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                        result ->
                    Log.d(TAG, "There are ${result.items.size} Java developers in Lagos")
                }, { error ->
                    Log.d(TAG,"the error was $error")
                    error.printStackTrace()
                })
        )

        compositeDisposable.add(
            repositoryDummy.searchDummyUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    Log.d(TAG, "the result is $result")
                }, { error ->
                    Log.d(TAG, "the error was $error")
                    error.printStackTrace()
                })
        )
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }


}
