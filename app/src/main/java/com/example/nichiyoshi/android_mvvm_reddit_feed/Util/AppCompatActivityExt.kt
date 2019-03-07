package com.example.nichiyoshi.android_mvvm_reddit_feed.Util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import com.example.nichiyoshi.android_mvvm_reddit_feed.MainViewModelFactory
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Repository
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.remote.FeedsRemoteDataSource

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, MainViewModelFactory(Repository(FeedsRemoteDataSource))).get(viewModelClass)