package com.example.positrontask.ui.itemsadapter

import androidx.recyclerview.widget.DiffUtil

data class Item(
    val id: String,
    val name: String,
    val imageRef: String,
    val price: String
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem == newItem

        }
    }
}
