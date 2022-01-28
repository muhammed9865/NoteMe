package com.example.noteme.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteme.pojo.model.Note
import com.example.noteme.pojo.repository.NotesRepository
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val repository: NotesRepository) : ViewModel() {
    private val _notes: MutableLiveData<List<Note>> = MutableLiveData(emptyList())

    fun getNotes(): LiveData<List<Note>> {
        viewModelScope.launch {
            _notes.value = repository.getAllNotes()
        }
        return _notes
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            repository.addNote(note)
        }

    }

}