package com.example.positrontask.ui.itemfragment

import com.example.positrontask.domain.usecases.items.GetItemUseCase
import kotlinx.coroutines.flow.take
import javax.inject.Inject

class ItemFragmentController @Inject constructor(
    private val getItemUseCase: GetItemUseCase
): ItemController {
    lateinit var itemView: ItemView

    override suspend fun fillData(id: String) = getItemUseCase.invoke(id).collect {
        itemView.fillData(it)
    }
}