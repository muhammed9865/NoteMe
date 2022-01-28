package com.example.noteme.ui.all.adapter.`interface`

import com.example.noteme.pojo.model.Note

interface NoteUtilties {
    fun deleteNote(note_id: Int)

    fun editNote(note: Note)
}