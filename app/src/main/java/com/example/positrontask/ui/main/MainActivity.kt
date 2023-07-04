package com.example.positrontask.ui.main

import android.os.Bundle
import com.example.positrontask.common.architecture.BaseActivity
import com.example.positrontask.databinding.ActivityMainBinding
import com.example.positrontask.ui.di.DaggerMainActivityComponent
import com.example.positrontask.ui.di.MainActivityComponent

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    val activityComponent: MainActivityComponent by lazy {
        DaggerMainActivityComponent.builder().dataComponent(component).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}