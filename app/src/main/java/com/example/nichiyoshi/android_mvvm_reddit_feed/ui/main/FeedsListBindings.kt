package com.example.nichiyoshi.android_mvvm_reddit_feed.ui.main

import android.databinding.BindingAdapter
import android.widget.ListView
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Feed

/**
 * Contains [BindingAdapter]s for the [Feed] list.
 */
object FeedsListBindings {

    @BindingAdapter("app:items")
    @JvmStatic fun setItems(listView: ListView, items: List<Feed>) {
        with(listView.adapter as FeedsAdapter) {
            replaceData(items)
        }
    }
}