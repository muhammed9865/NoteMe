package com.example.noteme.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.noteme.pojo.model.List

class HomeDiffCallback:DiffUtil.ItemCallback<List>() {
    override fun areItemsTheSame(oldItem: List, newItem: List): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: List, newItem: List): Boolean {
        return oldItem == newItem
    }

}