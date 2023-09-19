package com.ndmrzzzv.giphystock.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ndmrzzzv.giphystock.R
import com.ndmrzzzv.giphystock.databinding.FragmentDetailGifBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailGifBinding
    private val viewModel by viewModel<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_gif, container, false)

        return binding.root
    }

}