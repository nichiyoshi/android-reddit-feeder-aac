package com.example.nichiyoshi.android_mvvm_reddit_feed.data

import android.util.Log
import com.example.nichiyoshi.android_mvvm_reddit_feed.Util.Const.BASE_URL
import retrofit2.Retrofit
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class Repository(private val feedsRemoteDataSource: FeedsDataSource): FeedsDataSource {

    override suspend fun getFeeds(callback: FeedsDataSource.LoadFeedsCallback) = GlobalScope.launch(Dispatchers.Default){
        feedsRemoteDataSource.getFeeds(object:FeedsDataSource.LoadFeedsCallback{
            override fun onFeedsLoaded(feeds: List<Feed>) {
                callback.onFeedsLoaded(feeds)
            }

            override fun onFeedLoadFailed() {
                callback.onFeedLoadFailed()
            }
        })
    }
}