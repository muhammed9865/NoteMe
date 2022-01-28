package com.example.noteme.pojo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.collections.List

@Entity(tableName = "list_table")
data class List(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val notes: List<Note>
)