package com.example.positrontask.common.architecture

import androidx.fragment.app.Fragment

interface FragmentComponent<T : Fragment> {
    fun inject(fragment: T)
}