package com.deepkverma.d_android_memory_usage.di

import android.app.Application
import com.deepkverma.d_android_memory_usage.App
import com.deepkverma.d_android_memory_usage.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent  {
    fun inject(application: App)
    fun inject(activity: MainActivity)

}