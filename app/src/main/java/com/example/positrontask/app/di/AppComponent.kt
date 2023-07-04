package com.example.positrontask.app.di

import android.content.Context
import dagger.Component

@AppScope
@Component(
    modules =[
        AppModule::class
    ]
)
interface AppComponent {
    val context: Context
}