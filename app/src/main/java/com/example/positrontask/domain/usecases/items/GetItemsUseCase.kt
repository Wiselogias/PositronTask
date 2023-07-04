package com.example.positrontask.domain.usecases.items

import com.example.positrontask.domain.entities.ItemEntity
import com.example.positrontask.domain.repositories.ItemRepo
import com.example.positrontask.domain.usecases.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val itemRepo: ItemRepo
): UseCase<Unit, List<ItemEntity>>{
    override suspend fun invoke(input: Unit): Flow<List<ItemEntity>> = flow {
        emit(itemRepo.getItems())
    }
}