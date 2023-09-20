package com.ndmrzzzv.giphystock.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndmrzzzv.domain.model.Gif
import com.ndmrzzzv.domain.usecase.GetAllTrendGifsUseCase
import com.ndmrzzzv.giphystock.fragment.features.InternetConnectManager
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllTrendGifsUseCase: GetAllTrendGifsUseCase,
    private val internetConnect: InternetConnectManager
) : ViewModel() {

    private val _gifs = MutableLiveData<List<Gif>?>()
    val gifs: LiveData<List<Gif>?> = _gifs

    init {
        viewModelScope.launch {
            if (internetConnect.check()) {
                _gifs.value = getAllTrendGifsUseCase.invoke()
            } else {
                _gifs.value = null
            }
        }
    }

}