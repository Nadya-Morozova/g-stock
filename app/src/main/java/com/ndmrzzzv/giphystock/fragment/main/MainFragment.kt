package com.ndmrzzzv.giphystock.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ndmrzzzv.giphystock.databinding.FragmentMainListBinding
import com.ndmrzzzv.giphystock.fragment.main.view.adapter.GifAdapter
import com.ndmrzzzv.giphystock.fragment.main.view.interfaces.NavigateToGifListener
import com.ndmrzzzv.giphystock.fragment.features.FullscreenFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(), NavigateToGifListener {

    private var _binding: FragmentMainListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<MainViewModel>()
    private val adapter = GifAdapter(listOf(), this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FullscreenFragment.hide(activity?.window, binding.root)

        initObservers()
        initializeRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservers() {
        viewModel.gifs.observe(viewLifecycleOwner) {
            if (it == null) {
                binding.tvMessage.visibility = View.VISIBLE
                return@observe
            }

            adapter.setList(it)
        }
    }

    private fun initializeRecyclerView() {
        binding.rvGifs.adapter = adapter
        binding.rvGifs.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun navigate(id: String) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToDetailFragment(id)
        )
    }

}