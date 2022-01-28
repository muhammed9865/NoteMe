package com.example.noteme.ui.all.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.noteme.pojo.model.Note

class AllDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }


}