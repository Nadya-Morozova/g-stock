package com.ndmrzzzv.domain.repository

import com.ndmrzzzv.domain.model.Gif

interface GifRepository {

    suspend fun getAllTrendGifs(): List<Gif>

    suspend fun getDetailedGif(id: String): Gif

}