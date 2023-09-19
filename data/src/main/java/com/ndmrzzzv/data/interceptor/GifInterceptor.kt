package com.ndmrzzzv.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class GifInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newUrl = request.url.newBuilder()
            .addQueryParameter("api_key", "FrH7U8B1VAy0v4siFTI5KEl2VL2XEQ8O")
            .addQueryParameter("limit", "20")
            .addQueryParameter("rating", "g")
            .build()

        val newRequest = request.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

}