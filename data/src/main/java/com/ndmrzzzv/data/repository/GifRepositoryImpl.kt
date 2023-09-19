package com.ndmrzzzv.data.repository

import android.util.Log
import com.ndmrzzzv.data.api.GiphyApi
import com.ndmrzzzv.domain.model.Gif
import com.ndmrzzzv.domain.repository.GifRepository

class GifRepositoryImpl(
    private val gifsApi: GiphyApi
) : GifRepository {

    override suspend fun getAllTrendGifs(): List<Gif> {
        val newList = mutableListOf<Gif>()
        for (res in gifsApi.getTrendingGifs().data) {
            newList.add(Gif(res.id, res.title, res.images.original.url))
        }
        return newList
    }

    override suspend fun getDetailedGif(id: String): Gif {
        val result = gifsApi.getGif(id).data
        return Gif(result.id, result.title, result.images.original.url)
    }

}