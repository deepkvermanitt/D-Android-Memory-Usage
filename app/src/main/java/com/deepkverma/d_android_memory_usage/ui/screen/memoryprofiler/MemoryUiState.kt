package com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler

sealed class MemoryUiState {
    data class Log(val message: String) : MemoryUiState()
    object Idle : MemoryUiState()
}