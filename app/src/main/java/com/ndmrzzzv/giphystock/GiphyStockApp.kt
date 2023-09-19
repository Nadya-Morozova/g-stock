package com.ndmrzzzv.giphystock

import android.app.Application
import com.ndmrzzzv.data.module.dataModule
import com.ndmrzzzv.giphystock.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GiphyStockApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GiphyStockApp)
            modules(listOf(dataModule, appModule))
        }
    }

}