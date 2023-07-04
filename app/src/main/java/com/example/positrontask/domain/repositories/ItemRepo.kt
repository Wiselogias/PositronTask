package com.example.positrontask.domain.repositories

import com.example.positrontask.domain.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

interface ItemRepo {
   fun getItems(): Flow<List<ItemEntity>>
   fun getItem(id: String): Flow<ItemEntity>
   suspend fun addItem(itemEntity: ItemEntity)
}