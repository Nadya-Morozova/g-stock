package com.ndmrzzzv.data.api

import com.ndmrzzzv.data.data.Gif
import retrofit2.http.GET

interface GiphyApi {

    @GET("trending")
    suspend fun getTrendingGifs(): Gif

}