package com.example.nichiyoshi.android_mvvm_reddit_feed.ui.main

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Feed
import com.example.nichiyoshi.android_mvvm_reddit_feed.databinding.FeedItemBinding

class FeedsAdapter(
    private var feeds: List<Feed>
) : BaseAdapter() {

    fun replaceData(feeds: List<Feed>) {
        setList(feeds)
    }

    override fun getCount() = feeds.size

    override fun getItem(position: Int) = feeds[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        val binding: FeedItemBinding
        binding = if (view == null) {
            // Inflate
            val inflater = LayoutInflater.from(viewGroup.context)

            // Create the binding
            FeedItemBinding.inflate(inflater, viewGroup, false)
        } else {
            // Recycling view
            DataBindingUtil.getBinding(view) ?: throw IllegalStateException()
        }

        with(binding) {
            feed = feeds[position]
        }

        return binding.root
    }


    private fun setList(tasks: List<Feed>) {
        this.feeds = tasks
        notifyDataSetChanged()
    }
}
