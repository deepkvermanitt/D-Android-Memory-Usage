package com.deepkverma.d_android_memory_usage.di

import com.deepkverma.d_android_memory_usage.App
import com.deepkverma.d_android_memory_usage.utils.MemoryLogger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: App) {

    @Singleton
    @Provides
    fun provideApplication(): App = application

    @Singleton
    @Provides
    fun provideMemoryLogger(): MemoryLogger {
        return MemoryLogger()
    }
}