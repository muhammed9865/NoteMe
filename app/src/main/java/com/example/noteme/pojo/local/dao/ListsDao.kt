package com.example.noteme.pojo.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ListsDao {

    @Query("SELECT * from list_table")
    suspend fun getLists():List<com.example.noteme.pojo.model.List>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addList(list: com.example.noteme.pojo.model.List)

    /*@Query("SELECT * FROM LIST_TABLE INNER JOIN notes_table ON listName = title WHERE title LIKE :list_name")
    suspend fun getListByName(list_name: String): com.example.noteme.pojo.model.List*/

}