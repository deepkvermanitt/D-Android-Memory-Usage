package com.deepkverma.d_android_memory_usage.ui.screen.memoryprofiler

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.deepkverma.d_android_memory_usage.R

typealias onExecute = () -> Unit

@Composable
fun MemoryProfilerScreen(
    onExecute: onExecute,
    viewModel: MemoryProfilerViewModel
) {

    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = onExecute,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(
                text = stringResource(R.string.execute_button),

                color = Color.White
            )
        }



        Spacer(Modifier.height(16.dp))
        when (uiState) {
            is MemoryUiState.Log ->
                Text(

                    text = (uiState as MemoryUiState.Log).message,

                    color = Color.Black
                )

            MemoryUiState.Idle -> Text("No logs yet")

        }
    }

}