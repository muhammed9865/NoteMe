package com.example.noteme.ui.all.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteme.pojo.model.Note
import com.example.noteme.pojo.repository.NotesRepository
import kotlinx.coroutines.launch

class AllFragmentViewModel(private val repo: NotesRepository) : ViewModel() {

    private val notes: MutableLiveData<List<Note>> = MutableLiveData(emptyList())

    fun getNotes(): LiveData<List<Note>> {
        viewModelScope.launch {
            notes.value = repo.getAllNotes()
        }
        return notes
    }

    fun deleteNote(note_id: Int) {
        viewModelScope.launch {
            repo.deleteNote(note_id)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repo.updateNote(note)
        }
    }
}