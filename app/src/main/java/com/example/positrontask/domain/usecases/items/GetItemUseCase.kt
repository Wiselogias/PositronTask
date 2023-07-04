package com.example.positrontask.domain.usecases.items

import com.example.positrontask.domain.entities.ItemEntity
import com.example.positrontask.domain.repositories.ItemRepo
import com.example.positrontask.domain.usecases.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetItemUseCase @Inject constructor(
    private val itemRepo: ItemRepo
): UseCase<String, ItemEntity>{
    override suspend fun invoke(input: String): Flow<ItemEntity> = flow {
        emit(itemRepo.getItem(input))
    }
}