package com.example.positrontask.ui.shopfragment

import com.example.positrontask.domain.usecases.items.GetItemsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.take
import javax.inject.Inject

class ShopFragmentController @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
): ShopController {
    lateinit var shopView: ShopView

    override suspend fun getItems() = getItemsUseCase.invoke(Unit).take(1).collect {
        shopView.fillData(it)
    }
}