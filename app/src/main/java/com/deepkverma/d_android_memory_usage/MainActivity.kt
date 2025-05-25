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
import com.deepkverma.d_android_memory_usage.di.AppComponent
import com.deepkverma.d_android_memory_usage.di.AppModule
import com.deepkverma.d_android_memory_usage.di.DaggerAppComponent
import com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler.MemoryProfilerScreen
import com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler.MemoryProfilerViewModel
import com.deepkverma.d_android_memory_usage.ui.theme.DAndroidMemoryUsageTheme
import com.deepkverma.d_android_memory_usage.utils.MemoryLogger
import com.deepkverma.d_android_memory_usage.utils.MemoryLogger.*
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var memoryLoggerViaDagger: MemoryLogger
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appComponent =
            DaggerAppComponent.builder().appModule(AppModule(application as App)).build()
        appComponent.inject(this)
        enableEdgeToEdge()
        setContent {
            memoryLoggerViaDagger.logCurrentMemoryProfile("setContent")
            DAndroidMemoryUsageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    memoryLoggerViaDagger.logCurrentMemoryProfile("MemoryProfilerScreen Before")
                    val memViewModel: MemoryProfilerViewModel = viewModel()

                    MemoryProfilerScreen(viewModel = memViewModel, onExecute = {
                        memoryLoggerViaDagger.logCurrentMemoryProfile("onExecute Before")
                        memViewModel.logMemory()
                        memoryLoggerViaDagger.logCurrentMemoryProfile("onExecute After")

                    })
                    memoryLoggerViaDagger.logCurrentMemoryProfile("MemoryProfilerScreen After")

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