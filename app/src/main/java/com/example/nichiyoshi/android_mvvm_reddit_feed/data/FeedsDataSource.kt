package com.example.nichiyoshi.android_mvvm_reddit_feed.data

import kotlinx.coroutines.Job


interface FeedsDataSource {

    interface LoadFeedsCallback {

        fun onFeedsLoaded(tasks: List<Feed>)

        fun onFeedLoadFailed()

    }

    suspend fun getFeeds(callback: LoadFeedsCallback): Job

}