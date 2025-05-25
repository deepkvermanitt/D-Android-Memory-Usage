package com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler

import androidx.lifecycle.ViewModel
import com.deepkverma.d_android_memory_usage.utils.MemoryLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MemoryProfilerViewModel : ViewModel() {
    val memoryLogger: MemoryLogger = MemoryLogger()

    private val _UiState = MutableStateFlow<MemoryUiState>(MemoryUiState.Idle)
    val uiState: StateFlow<MemoryUiState> = _UiState.asStateFlow()

    fun logMemory(){
        _domemoryIntensiveTask()
        val log = memoryLogger.logCurrentMemoryProfile("App Launched")
        _UiState.value = MemoryUiState.Log(log)
    }
    fun _domemoryIntensiveTask(){
        memoryLogger.addListOfInt()
    }

}