package com.example.positrontask.data.db.mappers

import com.example.positrontask.data.db.entities.ItemRoomEntity
import com.example.positrontask.domain.entities.ItemEntity

object ItemMapper {
    fun fromRoomEntityToDomainEntity(itemRoomEntity: ItemRoomEntity) = ItemEntity(
        id = itemRoomEntity.id,
        name = itemRoomEntity.name,
        price = itemRoomEntity.price,
        image = itemRoomEntity.image
    )

    fun fromDomainEntityToRoomEntity(itemEntity: ItemEntity) = ItemRoomEntity(
        id = itemEntity.id,
        name = itemEntity.name,
        price = itemEntity.price,
        image = itemEntity.image
    )
}