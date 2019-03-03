package com.example.nichiyoshi.android_mvvm_reddit_feed.data

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RedditService {

    @GET("hot.json")
    fun fetchFeedsAsync(): Deferred<Response>

}