package com.example.positrontask.data.repositories

import com.example.positrontask.data.db.dao.ItemDao
import com.example.positrontask.data.db.mappers.ItemMapper
import com.example.positrontask.domain.entities.ItemEntity
import com.example.positrontask.domain.repositories.ItemRepo
import javax.inject.Inject

class ItemRepoImpl @Inject constructor(
    private val itemDao: ItemDao,
) : ItemRepo{
    override suspend fun getItems(): List<ItemEntity> =
        itemDao.getItems().map { ItemMapper.fromRoomEntityToDomainEntity(it) }


    override suspend fun getItem(id: String): ItemEntity =
        ItemMapper.fromRoomEntityToDomainEntity(itemDao.getItem(id))

    override suspend fun addItem(itemEntity: ItemEntity) {
        itemDao.upsert(ItemMapper.fromDomainEntityToRoomEntity(itemEntity))
    }
}