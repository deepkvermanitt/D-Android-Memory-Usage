package com.deepkverma.d_android_memory_usage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler.MemoryProfilerScreen
import com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler.MemoryProfilerViewModel
import com.deepkverma.d_android_memory_usage.ui.theme.DAndroidMemoryUsageTheme
import com.deepkverma.d_android_memory_usage.utils.addListOfInt
import com.deepkverma.d_android_memory_usage.utils.logCurrentMemoryProfile

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            logCurrentMemoryProfile("setContent")
            DAndroidMemoryUsageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    logCurrentMemoryProfile("MemoryProfilerScreen Before")
                    val memViewModel: MemoryProfilerViewModel = viewModel()

                    MemoryProfilerScreen(viewModel = memViewModel, onExecute = {
                        logCurrentMemoryProfile("onExecute Before")
                        memViewModel.logMemory()
                        logCurrentMemoryProfile("onExecute After")

                    })
                    logCurrentMemoryProfile("MemoryProfilerScreen After")

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}