package com.example.positrontask.ui.startfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.positrontask.R
import com.example.positrontask.common.architecture.BaseFragment
import com.example.positrontask.databinding.StartFragmentBinding
import com.example.positrontask.ui.main.MainActivity
import kotlinx.coroutines.launch
import javax.inject.Inject

class StartFragment: BaseFragment<MainActivity>(){
    @Inject
    lateinit var controller: StartFragmentController

    private lateinit var binding: StartFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity.activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = StartFragmentBinding.inflate(inflater, container, false)

        baseActivity.lifecycleScope.launch {
            controller.updateData()
        }

        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_shopFragment)
        }
        return binding.root
    }
}