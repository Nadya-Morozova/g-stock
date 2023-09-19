package com.ndmrzzzv.giphystock.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndmrzzzv.domain.model.Gif
import com.ndmrzzzv.domain.usecase.GetDetailedGifUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getDetailedGifUseCase: GetDetailedGifUseCase
): ViewModel() {

    private val _gif = MutableLiveData<Gif>()
    val gif: LiveData<Gif> = _gif

    fun getInfoAboutGif(id: String) {
        viewModelScope.launch {
            _gif.value = getDetailedGifUseCase.invoke(id)
        }
    }

}