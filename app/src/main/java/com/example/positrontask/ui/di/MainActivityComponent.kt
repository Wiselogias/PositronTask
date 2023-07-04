package com.example.positrontask.ui.di

import com.example.positrontask.data.di.DataComponent
import com.example.positrontask.ui.main.MainActivity
import com.example.positrontask.ui.itemfragment.ItemFragment
import com.example.positrontask.ui.shopfragment.ShopFragment
import com.example.positrontask.ui.startfragment.StartFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [
        DataComponent::class
    ]
)
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: ItemFragment)
    fun inject(fragment: ShopFragment)
    fun inject(fragment: StartFragment)
}