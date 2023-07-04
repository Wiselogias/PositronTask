package com.example.positrontask.ui.itemfragment

import com.example.positrontask.domain.entities.ItemEntity

interface ItemView {
    fun fillData(itemEntity: ItemEntity)
}