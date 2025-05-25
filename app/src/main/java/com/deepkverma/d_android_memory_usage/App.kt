package com.deepkverma.d_android_memory_usage

import android.app.Application
import com.deepkverma.d_android_memory_usage.di.AppModule
import com.deepkverma.d_android_memory_usage.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.inject(this)
        Timber.plant(Timber.DebugTree())
        Timber.d("ApplicationLaunched")
    }
}