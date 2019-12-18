package com.example.mytestitunesnew

import android.app.Application
import com.example.mytestitunesnew.di.appModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

const val URL_BASE_API = "https://itunes.apple.com/"

open class MyTestitunesNewApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        AndroidThreeTen.init(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyTestitunesNewApp)
            modules(listOf(appModule))
        }
    }
}