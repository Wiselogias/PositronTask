package com.example.positrontask.ui.itemsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.positrontask.common.adapter.BaseAdapter
import com.example.positrontask.databinding.ItemCardBinding

class ItemAdapter(
    onClickListener: (Item) -> Unit
) : BaseAdapter<Item, ItemViewHolder>(
    Item.DIFF_CALLBACK, onClickListener
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
}