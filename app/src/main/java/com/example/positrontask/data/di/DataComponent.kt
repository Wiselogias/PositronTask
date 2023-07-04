package com.example.positrontask.data.di

import com.example.positrontask.app.di.AppComponent
import com.example.positrontask.data.remote.api.PositronApi
import com.example.positrontask.domain.repositories.ItemRepo
import dagger.Component

@DataScope
@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        DataModule::class
    ]
)
interface DataComponent {
    val positronApi: PositronApi
    val itemRepo: ItemRepo
}