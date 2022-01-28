package com.example.noteme.pojo.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteme.pojo.model.Note

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes_table")
    suspend fun getNotes():List<Note>

    @Insert
    suspend fun addNote(note: Note)

    @Query("DELETE FROM NOTES_TABLE WHERE id LIKE :note_id")
    suspend fun removeNoteByID(note_id: Int): Int

    @Query("SELECT * FROM notes_table WHERE isFavourite IS 1")
    suspend fun getFavouritesNotes():List<Note>

    @Query("SELECT * FROM notes_table WHERE title MATCH :query")
    suspend fun searchByQuery(query: String):List<Note>

    @Update
    suspend fun updateNote(note: Note)
}