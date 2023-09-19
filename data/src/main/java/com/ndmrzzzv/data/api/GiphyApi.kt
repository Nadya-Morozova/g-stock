package com.ndmrzzzv.data.api

import com.ndmrzzzv.data.data.Gif
import com.ndmrzzzv.data.data.OneGif
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GiphyApi {

    @GET("trending")
    suspend fun getTrendingGifs(
        @Query("limit") limit: Int = 20,
        @Query("rating") rating: String = "g",
    ): Gif

    @GET("{gif_id}")
    suspend fun getGif(@Path("gif_id") id: String): OneGif

}