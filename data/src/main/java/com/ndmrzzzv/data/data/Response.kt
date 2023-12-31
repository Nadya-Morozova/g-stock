package com.ndmrzzzv.data.data

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("images") val images: Images
)