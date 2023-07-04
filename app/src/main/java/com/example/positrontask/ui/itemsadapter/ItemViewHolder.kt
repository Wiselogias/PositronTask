package com.example.positrontask.ui.itemsadapter

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide
import com.example.positrontask.R
import com.example.positrontask.common.adapter.BaseViewHolder
import com.example.positrontask.databinding.ItemCardBinding

class ItemViewHolder(
    binding: ItemCardBinding
): BaseViewHolder<Item, ItemCardBinding>(binding) {
    @SuppressLint("SetTextI18n")
    override fun bind(model: Item) {
        binding.itemName.text = model.name
        binding.VendorCode.text = model.id
        binding.price.text = model.price + "р"
        if (model.imageRef.isEmpty()) {
            binding.imageRef.scaleType = ImageView.ScaleType.CENTER_INSIDE
            binding.imageRef.setImageDrawable(
                AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.round_hide_image_24
                )
            )
        } else {
            binding.imageRef.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide
                .with(binding.imageRef)
                .load("https://vimos.ru" + model.imageRef)
                .centerCrop()
                .into(binding.imageRef)
        }
    }
}