package com.example.apitimes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apitimes.R
import com.example.apitimes.databinding.FragmentMenuBinding
import com.example.apitimes.ui.adapter.BaseComponentListAdapter
import com.example.apitimes.ui.adapter.TeamsListAdapter
import com.example.apitimes.viewmodel.home.HomeViewModel
import com.example.apitimes.viewmodel.model.HomeState
import kotlinx.coroutines.flow.combine
import org.koin.androidx.viewmodel.ext.android.viewModel


class MenuFragment : Fragment() {
    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var binding: FragmentMenuBinding
    private val adapter by lazy { BaseComponentListAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
        setupViews()
    }

    private fun setupViews() {
        binding.rvAllItems.adapter = adapter
    }

    private fun setupListeners() {

    }

    private fun setupObservers() {
        viewModel.listHomeLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeState.OnSuccessList -> {
                    adapter.submitList(state.result.toMutableList())
                }
            }
        }
    }


}