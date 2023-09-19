package com.ndmrzzzv.giphystock.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ndmrzzzv.giphystock.databinding.FragmentMainListBinding
import com.ndmrzzzv.giphystock.fragment.main.view.adapter.GifAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainListBinding
    private val viewModel by viewModel<MainViewModel>()
    private val adapter = GifAdapter(listOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllGifs()

        initObservers()
        initializeRecyclerView()
    }

    private fun initObservers() {
        viewModel.gifs.observe(viewLifecycleOwner) {
            adapter.update(it)
        }
    }

    private fun initializeRecyclerView() {
        binding.rvGifs.adapter = adapter
        binding.rvGifs.layoutManager = GridLayoutManager(requireContext(), 2)
    }

}