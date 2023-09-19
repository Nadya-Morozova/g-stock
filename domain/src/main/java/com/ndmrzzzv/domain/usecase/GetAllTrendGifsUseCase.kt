package com.ndmrzzzv.domain.usecase

import com.ndmrzzzv.domain.model.Gif
import com.ndmrzzzv.domain.repository.GifRepository

class GetAllTrendGifsUseCase(
    private val gifRepository: GifRepository
) {

    suspend fun invoke(): List<Gif> {
        return gifRepository.getAllTrendGifs()
    }

}