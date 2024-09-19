package com.example.learningcompose.wellnessApp

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier){
//    WaterCounter(modifier = Modifier)
//    StatefulCounter(modifier = modifier)

//    WellnessTaskList(modifier = modifier)

    Column {
//        WaterCounter(modifier = modifier)
        WellnessTaskList(modifier = modifier)
    }

}