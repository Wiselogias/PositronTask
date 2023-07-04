package com.example.positrontask.data.repositories

import com.example.positrontask.data.db.dao.ItemDao
import com.example.positrontask.data.db.mappers.ItemMapper
import com.example.positrontask.domain.entities.ItemEntity
import com.example.positrontask.domain.repositories.ItemRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ItemRepoImpl @Inject constructor(
    private val itemDao: ItemDao,
) : ItemRepo {
    override fun getItems(): Flow<List<ItemEntity>> =
        itemDao.getItems().map { list -> list.map { ItemMapper.fromRoomEntityToDomainEntity(it) } }


    override fun getItem(id: String): Flow<ItemEntity> =
        itemDao.getItem(id).map { ItemMapper.fromRoomEntityToDomainEntity(it) }

    override suspend fun addItem(itemEntity: ItemEntity) {
        itemDao.upsert(ItemMapper.fromDomainEntityToRoomEntity(itemEntity))
    }
}