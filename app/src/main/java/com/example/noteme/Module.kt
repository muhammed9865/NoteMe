package com.example.noteme

import android.content.Context
import androidx.room.RoomDatabase
import com.example.noteme.pojo.local.NotesDatabase

import dagger.Module
import dagger.Provides

@Module
class Module {
    @Provides
    fun provideDatabase(context: Context): NotesDatabase {
        return NotesDatabase.getInstance(context)
    }

}