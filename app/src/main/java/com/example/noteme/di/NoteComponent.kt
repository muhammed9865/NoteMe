package com.example.noteme.di

import com.example.noteme.pojo.repository.NotesRepository
import com.example.noteme.ui.all.AllFragment
import dagger.Component


interface NoteComponent {

    fun getNotesRepository(): NotesRepository

    fun inject(fragment: AllFragment)
}