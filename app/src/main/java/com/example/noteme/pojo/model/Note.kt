package com.example.noteme.pojo.model

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
/*@Fts4(contentEntity = Note::class)*/
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var listName: String = "all",
    var title: String,
    var content: String,
    var isFavourite: Boolean = false
)

