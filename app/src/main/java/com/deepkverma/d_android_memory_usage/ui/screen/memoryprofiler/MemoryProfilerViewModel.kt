package com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler

import androidx.lifecycle.ViewModel
import com.deepkverma.d_android_memory_usage.utils.logCurrentMemoryProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MemoryProfilerViewModel : ViewModel() {
    private val _UiState = MutableStateFlow<MemoryUiState>(MemoryUiState.Idle)
    val uiState: StateFlow<MemoryUiState> = _UiState.asStateFlow()

    fun logMemory(){
        val log = logCurrentMemoryProfile("App Launched")
        _UiState.value = MemoryUiState.Log(log)
    }


}