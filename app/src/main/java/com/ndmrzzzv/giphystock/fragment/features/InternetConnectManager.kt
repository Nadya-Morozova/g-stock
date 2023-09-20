package com.ndmrzzzv.giphystock.fragment.features

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class InternetConnectManager(
    private val context: Context
) {

    fun check(): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = manager.activeNetwork ?: return false

        val networkCapabilities = manager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

}