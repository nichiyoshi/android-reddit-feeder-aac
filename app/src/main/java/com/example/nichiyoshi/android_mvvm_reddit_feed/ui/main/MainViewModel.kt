package com.example.nichiyoshi.android_mvvm_reddit_feed.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Feed
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.FeedsDataSource
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val feedsRepository: Repository) : ViewModel() {

    fun start(){
        loadFeeds()
    }

    private val _items = MutableLiveData<List<Feed>>().apply { value = emptyList() }
    val items: LiveData<List<Feed>>
        get() = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading

    private fun loadFeeds(){

        _dataLoading.postValue(true)

        GlobalScope.launch{

            feedsRepository.getFeeds(object: FeedsDataSource.LoadFeedsCallback{
                override fun onFeedsLoaded(feeds: List<Feed>) {
                    _items.postValue(feeds)
                    _dataLoading.postValue(false)
                }

                override fun onFeedLoadFailed() {
                    _dataLoading.postValue(false)
                }
            })
        }

    }

}
