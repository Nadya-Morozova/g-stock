package com.ndmrzzzv.giphystock.fragment.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ndmrzzzv.giphystock.R
import com.ndmrzzzv.giphystock.databinding.FragmentMainListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainListBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_list, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllGifs()

        viewModel.gifs.observe(viewLifecycleOwner) {
            it.forEach { gif ->
                Log.d("TESTTEST", gif.toString())
            }
        }
    }

}