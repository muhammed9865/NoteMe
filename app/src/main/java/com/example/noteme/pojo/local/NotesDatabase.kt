package com.example.noteme.pojo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteme.pojo.local.dao.ListsDao
import com.example.noteme.pojo.local.dao.NotesDao
import com.example.noteme.pojo.model.List
import com.example.noteme.pojo.model.ListConverter
import com.example.noteme.pojo.model.Note

@Database(
    entities = [Note::class, List::class],
    version = 3
)
@TypeConverters(ListConverter::class)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun getNotesDao(): NotesDao
    abstract fun getListsDao(): ListsDao

    companion object {
        private var instance: NotesDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context) = instance ?: synchronized(lock) {
            instance ?: Room
                .databaseBuilder(
                    context,
                    NotesDatabase::class.java,
                    "notes.db"
                ).fallbackToDestructiveMigration()
                .build()
        }
    }
}