package com.example.noteme.pojo.repository

import android.content.Context
import com.example.noteme.pojo.local.NotesDatabase
import com.example.noteme.pojo.model.List
import com.example.noteme.pojo.model.Note

class NotesRepository(db: NotesDatabase) {

    private val notesDao = db.getNotesDao()
    private val listsDao = db.getListsDao()

    suspend fun getAllNotes() = notesDao.getNotes()

    suspend fun searchNotesByTitle(query: String) = notesDao.searchByQuery(query)

    suspend fun addNote(note: Note) = notesDao.addNote(note)

    suspend fun deleteNote(note_id: Int) = notesDao.removeNoteByID(note_id)

    suspend fun updateNote(note: Note) = notesDao.updateNote(note)

    suspend fun getFavouriteNotes() = notesDao.getFavouritesNotes()

    suspend fun getLists() = listsDao.getLists()

    suspend fun addList(list: List) = listsDao.addList(list)

    companion object {
        private var instance: NotesRepository? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: NotesRepository(NotesDatabase.getInstance(context))
        }
    }

}