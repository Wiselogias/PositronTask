package com.example.positrontask.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.positrontask.data.db.entities.ItemRoomEntity

@Dao
abstract class ItemDao : CommonDao<ItemRoomEntity>() {
    @Query("SELECT * FROM items ORDER BY id")
    abstract suspend fun getItems(): List<ItemRoomEntity>

    @Query("SELECT * FROM items WHERE id = :id")
    abstract suspend fun getItem(id: String): ItemRoomEntity
}