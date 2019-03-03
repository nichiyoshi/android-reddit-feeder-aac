package com.example.nichiyoshi.android_mvvm_reddit_feed.data

data class Response(var data: Data)

data class Data(var children: List<Child>)

data class Child(var data: Feed)

data class Feed(var authorFullname: String, var title: String)