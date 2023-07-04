package com.example.positrontask.domain.usecases.items

import com.example.positrontask.domain.entities.ItemEntity
import com.example.positrontask.domain.repositories.ItemRepo
import com.example.positrontask.domain.usecases.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val itemRepo: ItemRepo
) : UseCase<Unit, List<ItemEntity>> {
    override fun invoke(input: Unit): Flow<List<ItemEntity>> = itemRepo.getItems()
}