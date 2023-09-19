package com.ndmrzzzv.giphystock.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndmrzzzv.domain.model.Gif
import com.ndmrzzzv.domain.usecase.GetAllTrendGifsUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllTrendGifsUseCase: GetAllTrendGifsUseCase
) : ViewModel() {

    private val _gifs = MutableLiveData<List<Gif>>()
    val gifs: LiveData<List<Gif>> = _gifs

    fun getAllGifs() {
        viewModelScope.launch {
            _gifs.value = getAllTrendGifsUseCase.invoke()
        }
    }

}