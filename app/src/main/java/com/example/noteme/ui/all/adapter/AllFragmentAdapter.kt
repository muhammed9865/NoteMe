package com.example.noteme.ui.all.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.noteme.databinding.NoteItemBinding
import com.example.noteme.pojo.model.Note
import com.example.noteme.ui.all.adapter.`interface`.NoteUtilties

class AllFragmentAdapter : ListAdapter<Note, AllViewHolder>(AllDiffCallback()) {
    private var noteUtilties: NoteUtilties? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllViewHolder {
        val binding: NoteItemBinding =
            NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AllViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllViewHolder, position: Int) {
        holder.bind(getItem(position),noteUtilties)
    }

    fun setNoteUtilties(noteUtilties: NoteUtilties) {
        this.noteUtilties = noteUtilties
    }
}