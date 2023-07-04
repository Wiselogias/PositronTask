package com.example.positrontask.ui.shopfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.positrontask.R
import com.example.positrontask.common.architecture.BaseFragment
import com.example.positrontask.databinding.ShopFragmentBinding
import com.example.positrontask.domain.entities.ItemEntity
import com.example.positrontask.ui.itemsadapter.Item
import com.example.positrontask.ui.itemsadapter.ItemAdapter
import com.example.positrontask.ui.itemsadapter.ItemMapper
import com.example.positrontask.ui.main.MainActivity
import kotlinx.coroutines.launch
import javax.inject.Inject


class ShopFragment: BaseFragment<MainActivity>(), ShopView {
    @Inject
    lateinit var controller: ShopFragmentController

    private lateinit var binding: ShopFragmentBinding

    private val itemsAdapter by lazy {
        ItemAdapter {
            findNavController().navigate(R.id.action_shopFragment_to_itemFragment, bundleOf("id" to it.id))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity.activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShopFragmentBinding.inflate(inflater, container, false)
        controller.shopView = this

        binding.shopView.apply {
            adapter = itemsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            controller.getItems()
        }
    }

    override fun fillData(listItems: List<ItemEntity>) {
        itemsAdapter.items = listItems.map { ItemMapper.fromDomainEntityToMapper(it) }
    }
}