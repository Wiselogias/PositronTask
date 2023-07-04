package com.example.positrontask.domain.repositories

import com.example.positrontask.domain.entities.ItemEntity

interface ItemRepo {
    suspend fun getItems(): List<ItemEntity>
    suspend fun getItem(id: String): ItemEntity
    suspend fun addItem(itemEntity: ItemEntity)
}