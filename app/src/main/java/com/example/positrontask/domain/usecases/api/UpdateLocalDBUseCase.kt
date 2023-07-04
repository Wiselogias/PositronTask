package com.example.positrontask.domain.usecases.api

import com.example.positrontask.data.db.mappers.ItemMapper
import com.example.positrontask.data.remote.api.PositronApi
import com.example.positrontask.domain.entities.ItemEntity
import com.example.positrontask.domain.repositories.ItemRepo
import com.example.positrontask.domain.usecases.UseCase
import kotlinx.coroutines.flow.Flow
import java.security.PrivateKey
import javax.inject.Inject

class UpdateLocalDBUseCase @Inject constructor(
    private val positronApi: PositronApi,
    private val itemRepo: ItemRepo
) {
    suspend fun invoke() {
        positronApi.getItemsRemote(
            cat_id = 1000457,
            limit = 100,
            offset = 0,
            base_id = 1,
            sort_type = 0
        ).body()?.map {
            ItemEntity(
                id = it.id.toString(),
                name = it.name,
                price = it.price.toString(),
                image = it.imageRef
            )
        }?.forEach { itemRepo.addItem(it) }
    }
}