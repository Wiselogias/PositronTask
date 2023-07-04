package com.example.positrontask.data.di

import com.example.positrontask.data.db.di.DatabaseModule
import com.example.positrontask.data.remote.di.RemoteModule
import com.example.positrontask.data.repositories.ItemRepoImpl
import com.example.positrontask.domain.repositories.ItemRepo
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        DatabaseModule::class,
        RemoteModule::class
    ]
)
abstract class DataModule {
    @Binds
    @DataScope
    abstract fun bindItemRepo(itemRepoImpl: ItemRepoImpl): ItemRepo
}