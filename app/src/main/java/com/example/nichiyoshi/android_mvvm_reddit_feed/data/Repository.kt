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

class Repository: FeedsDataSource {

    override suspend fun getFeeds(callback: FeedsDataSource.LoadFeedsCallback) = GlobalScope.launch(Dispatchers.Default){
        try{
            val response = getService().fetchFeedsAsync().await()
            val data = response.data
            val feeds = data.children.map{ it.data }
            callback.onFeedsLoaded(feeds)
        } catch (e: HttpException) {
            Log.e("error", e.toString())
            callback.onFeedLoadFailed()
        } catch (e: Throwable) {
            Log.e("error", e.toString())
            callback.onFeedLoadFailed()
        }
    }

    private fun getService(): RedditService{

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val instance =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
        return instance.create(RedditService::class.java)
    }

}