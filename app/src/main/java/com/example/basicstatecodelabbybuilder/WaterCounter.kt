package com.example.basicstatecodelabbybuilder

import androidx.compose.material.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0)}
    // --------
    StatelessCounter(count = count, onIncrement = { count++ }, modifier = modifier)
}

@Composable
private fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            var showTask by rememberSaveable { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?"
                )
            }
            Text("You've had $count glasses.")
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = onIncrement,
                enabled = count < 10,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Add one")
            }
        }
    }
}