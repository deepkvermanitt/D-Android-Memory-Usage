package com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.deepkverma.d_android_memory_usage.R

typealias onExecute = () -> Unit

@Composable
fun MemoryProfilerScreen(onExecute: onExecute) {

    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onExecute, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
            Text(
                text = stringResource(R.string.execute_button),

                color = Color.White
            )
        }
    }

}