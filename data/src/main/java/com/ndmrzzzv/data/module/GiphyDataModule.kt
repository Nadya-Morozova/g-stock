package com.ndmrzzzv.data.module

import com.ndmrzzzv.data.api.GiphyApi
import com.ndmrzzzv.data.interceptor.GifInterceptor
import com.ndmrzzzv.data.repository.GifRepositoryImpl
import com.ndmrzzzv.domain.repository.GifRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL = "https://api.giphy.com/v1/gifs/"

val dataModule = module {

    factory<GifRepository> { GifRepositoryImpl(get()) }

    single<GiphyApi> {
        val client = OkHttpClient.Builder()
            .addInterceptor(GifInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return@single retrofit.create(GiphyApi::class.java)
    }
}