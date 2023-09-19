package com.ndmrzzzv.data.data

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName("data") val data: List<Response>,
)
