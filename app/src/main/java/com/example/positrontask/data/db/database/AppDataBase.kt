package com.example.positrontask.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.positrontask.data.db.dao.ItemDao
import com.example.positrontask.data.db.entities.ItemRoomEntity

@Database(
    version = 1,
    entities = [
        ItemRoomEntity::class
    ],
    exportSchema = true
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getItemDao(): ItemDao
}