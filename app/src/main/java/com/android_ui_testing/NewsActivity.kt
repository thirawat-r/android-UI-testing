package com.android_ui_testing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.android_ui_testing.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private val binding: ActivityNewsBinding by lazy {
        ActivityNewsBinding.inflate(layoutInflater)
    }

    private var newsAdapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bindView()
    }

    private fun bindView() {
        newsAdapter = NewsAdapter()

        with(binding) {
            rvNews.adapter = newsAdapter

            btnSearch.setOnClickListener {
                searchNews(edtSearch.text.toString())
            }
        }
        newsAdapter?.itemList = getNewsList()
    }

    private fun searchNews(keyword: String) {
        val filterList = getNewsList().filter { it.contains(keyword) }
        newsAdapter?.itemList = filterList

        with(binding) {
            tvNoData.isVisible = filterList.isEmpty()
            rvNews.isVisible = filterList.isNotEmpty()
        }
    }

    private fun getNewsList(): List<String> {
        return mutableListOf(
            "US urges China to show restraint amid Taiwan drills",
            "Vitaly Votanovsky flees Russia after documenting a Wagner cemetery",
            "Maia and Rina Dee named as British-Israeli sisters killed in West Bank shooting",
            "Ben Ferencz: Last surviving Nuremberg prosecutor dies, aged 103",
            "The Bodyguard cut short in Manchester due to rowdy singalongs",
            "Thabo Bester: 'Facebook rapist' who faked death arrested in Tanzania",
            "Aurélien Pradié: The rising star shaking up French politics",
            "Iran installs cameras to find women not wearing hijab",
            "Ukraine to export electricity again after months of Russian attacks",
            "Covid origins: Chinese scientists publish long-awaited data",
        )
    }
}