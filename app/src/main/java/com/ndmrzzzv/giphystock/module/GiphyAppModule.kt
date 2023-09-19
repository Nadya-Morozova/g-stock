package com.ndmrzzzv.giphystock.module

import com.ndmrzzzv.domain.usecase.GetAllTrendGifsUseCase
import com.ndmrzzzv.domain.usecase.GetDetailedGifUseCase
import com.ndmrzzzv.giphystock.fragment.detail.DetailViewModel
import com.ndmrzzzv.giphystock.fragment.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { GetAllTrendGifsUseCase(get()) }

    single { GetDetailedGifUseCase(get()) }

    viewModel { MainViewModel(get()) }

    viewModel { DetailViewModel(get()) }

}