package com.example.noteme.pojo.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.collections.List


class ListConverter {
    private val gson = Gson()
    @TypeConverter
    fun listToString(data: List<Note>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToList(data: String): List<Note> {
        if (data.isEmpty()) {
            return emptyList()
        }

        val type = object: TypeToken<List<Note>>() {}.type

        return gson.fromJson(data, type)
    }
}