package com.example.noteme.ui.all.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.noteme.databinding.NoteItemBinding
import com.example.noteme.pojo.model.Note
import com.example.noteme.ui.all.adapter.`interface`.NoteUtilties

class AllViewHolder(private val binding: NoteItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Note, noteUtilties: NoteUtilties?) = with(item) {
        binding.apply {
            noteTitle.text = title
            noteContent.text = content

            noteUtilties?.let { util ->
                // Deletes the note from db using the note id
                deleteNote.setOnClickListener { util.deleteNote(item.id!!) }

                // Updates the note in db using the note object
                editNote.setOnClickListener { util.editNote(item) }

            }
        }
    }
}