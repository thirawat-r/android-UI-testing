package com.android_ui_testing

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter : RecyclerView.Adapter<NewsItemViewHolder>() {

    var itemList = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

}