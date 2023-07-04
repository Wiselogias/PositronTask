package com.example.positrontask.app

import android.app.Application
import com.example.positrontask.app.di.AppComponent
import com.example.positrontask.app.di.AppModule
import com.example.positrontask.app.di.DaggerAppComponent
import com.example.positrontask.data.di.DaggerDataComponent
import com.example.positrontask.data.di.DataComponent
import kotlin.properties.Delegates

class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
//        val dataComponent: DataComponent by Delegates.notNull<DataComponent>()
    val dataComponent: DataComponent by lazy {
        DaggerDataComponent.builder().appComponent(appComponent).build()
    }
}