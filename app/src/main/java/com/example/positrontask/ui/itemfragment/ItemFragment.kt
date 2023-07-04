package com.example.positrontask.ui.itemfragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.positrontask.common.architecture.BaseFragment
import com.example.positrontask.databinding.ItemFragmentBinding
import com.example.positrontask.domain.entities.ItemEntity
import com.example.positrontask.ui.main.MainActivity
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemFragment : BaseFragment<MainActivity>(),
    ItemView {
    @Inject
    lateinit var controller: ItemFragmentController

    private lateinit var binding: ItemFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity.activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemFragmentBinding.inflate(inflater, container, false)
        controller.itemView = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            controller.fillData(requireArguments().getString("id", ""))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun fillData(itemEntity: ItemEntity) {
        binding.itemName.text = itemEntity.name
        binding.VendorCode.text = itemEntity.id
        binding.priceButton.text = itemEntity.price + " р"
        Glide.with(binding.imageRef).load("https://vimos.ru" + itemEntity.image).into(binding.imageRef)
    }
}