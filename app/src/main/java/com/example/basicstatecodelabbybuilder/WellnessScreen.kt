package com.example.basicstatecodelabbybuilder

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)

        val list = remember { getWellnessTasks().toMutableStateList() }
        list.addAll(getWellnessTasks())
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }