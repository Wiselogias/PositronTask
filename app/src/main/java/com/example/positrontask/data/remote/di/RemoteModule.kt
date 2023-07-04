package com.example.positrontask.data.remote.di

import com.example.positrontask.data.di.DataScope
import com.example.positrontask.data.remote.api.PositronApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class RemoteModule {
    @DataScope
    @Provides
    @Named("url")
    fun provideUrl() =  "https://vimos.ru:1457/"

    @DataScope
    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    @DataScope
    fun provideRetrofit(@Named("url") url: String, gson: Gson): Retrofit =
        Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create(gson)).build()

    @Provides
    @DataScope
    fun provideItemsApi(retrofit: Retrofit): PositronApi = retrofit.create(PositronApi::class.java)
}