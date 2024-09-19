package com.example.learningcompose.wellnessApp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun  WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTask() }
){
    LazyColumn {
        items(list) {task ->
            WellnessTaskItem(taskName = task.label)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskListPreview(){
    WellnessTaskList()
}

fun getWellnessTask() = List(30){
    WellnessTask(it, "Task # $it")
}