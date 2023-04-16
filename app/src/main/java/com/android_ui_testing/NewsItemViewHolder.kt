package com.android_ui_testing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android_ui_testing.databinding.ItemNewsBinding

class NewsItemViewHolder(
    private val itemBinding: ItemNewsBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    companion object {
        fun create(parent: ViewGroup): NewsItemViewHolder {
            return NewsItemViewHolder(
                ItemNewsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bindView(title: String) {
        with(itemBinding) {
            tvTitle.text = title
        }
    }
}