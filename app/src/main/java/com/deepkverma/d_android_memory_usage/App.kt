package com.deepkverma.d_android_memory_usage

import android.app.Application
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.d("ApplicationLaunched")
    }
}