package com.example.positrontask.data.db.di

import android.content.Context
import androidx.room.Room
import com.example.positrontask.data.db.dao.ItemDao

import com.example.positrontask.data.db.database.AppDataBase
import com.example.positrontask.data.di.DataScope
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    @DataScope
    fun provideDatabase(context: Context): AppDataBase = Room
        .databaseBuilder(context, AppDataBase::class.java, "PositronDB")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @DataScope
    fun provideItemDao(appDataBase: AppDataBase): ItemDao = appDataBase.getItemDao()
}