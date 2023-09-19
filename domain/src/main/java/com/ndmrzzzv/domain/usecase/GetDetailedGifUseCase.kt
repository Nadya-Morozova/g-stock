package com.ndmrzzzv.domain.usecase

import com.ndmrzzzv.domain.model.Gif
import com.ndmrzzzv.domain.repository.GifRepository

class GetDetailedGifUseCase(
    private val gifRepository: GifRepository
) {

    suspend fun invoke(id: String): Gif {
        return gifRepository.getDetailedGif(id)
    }

}