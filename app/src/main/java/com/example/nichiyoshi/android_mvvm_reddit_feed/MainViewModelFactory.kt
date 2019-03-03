package com.example.nichiyoshi.android_mvvm_reddit_feed

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Repository
import com.example.nichiyoshi.android_mvvm_reddit_feed.ui.main.MainViewModel

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }


}