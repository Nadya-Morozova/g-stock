package com.ndmrzzzv.giphystock.fragment.detail

import androidx.lifecycle.ViewModel
import com.ndmrzzzv.domain.usecase.GetDetailedGifUseCase

class DetailViewModel(
    private val getDetailedGifUseCase: GetDetailedGifUseCase
): ViewModel() {
}