package com.example.positrontask.ui.itemsadapter

import com.example.positrontask.domain.entities.ItemEntity

object ItemMapper {
    fun fromDomainEntityToMapper(itemEntity: ItemEntity) =
        Item(
            id = itemEntity.id,
            name = itemEntity.name,
            price = itemEntity.price,
            imageRef = itemEntity.image
        )
}