package com.example.positrontask.ui.itemfragment

import com.example.positrontask.domain.entities.ItemEntity

interface ItemController {
    suspend fun fillData(id: String)
}