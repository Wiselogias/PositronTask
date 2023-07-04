package com.example.positrontask.ui.shopfragment

import com.example.positrontask.domain.entities.ItemEntity

interface ShopView {
    fun fillData(listItems: List<ItemEntity>)
}