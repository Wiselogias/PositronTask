package com.example.positrontask.ui.startfragment

import com.example.positrontask.domain.usecases.api.UpdateLocalDBUseCase
import javax.inject.Inject

class StartFragmentController @Inject constructor(
    private val updateLocalDBUseCase: UpdateLocalDBUseCase
): StartController{


    override suspend fun updateData() = updateLocalDBUseCase.invoke()
}