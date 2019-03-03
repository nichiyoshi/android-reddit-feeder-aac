package com.example.nichiyoshi.android_mvvm_reddit_feed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nichiyoshi.android_mvvm_reddit_feed.Util.obtainViewModel
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Feed
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Response
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.FeedsDataSource
import com.example.nichiyoshi.android_mvvm_reddit_feed.data.Repository
import com.example.nichiyoshi.android_mvvm_reddit_feed.ui.main.MainFragment
import com.example.nichiyoshi.android_mvvm_reddit_feed.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }


        val repository = Repository()
        GlobalScope.launch(Dispatchers.Default){
            repository.getFeeds(object: FeedsDataSource.LoadFeedsCallback{
                override fun onFeedsLoaded(feeds: List<Feed>) {
                    Log.i("ほげ", "ここ通ってる")
                    if(feeds.isEmpty()){
                        Log.i(this@MainActivity::class.simpleName, "空っぽだよ")
                    }else{
                        Log.i(this@MainActivity::class.simpleName, "サイズは${feeds.size}")
                    }
                }

                override fun onFeedLoadFailed() {
                    Log.i("ほげ", "こっち通ってる")
                }

            })
        }

    }

    fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)

}
