package com.example.positrontask.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.positrontask.data.db.entities.ItemRoomEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ItemDao : CommonDao<ItemRoomEntity>() {
    @Query("SELECT * FROM items ORDER BY id")
    abstract fun getItems(): Flow<List<ItemRoomEntity>>

    @Query("SELECT * FROM items WHERE id = :id")
    abstract fun getItem(id: String): Flow<ItemRoomEntity>
}