package com.example.learningcompose.wellnessApp

import android.graphics.fonts.FontStyle
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.button.MaterialButton

@Composable
fun WaterCounter(modifier: Modifier) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
//        val count: MutableState<Int> = remember {
//            mutableIntStateOf(0)
//        }

        var count by rememberSaveable {
            mutableStateOf(0)
        }
        if (count > 0) {
//            Text(
//                text = "You had ${count} glasses",
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(),
//                textAlign = TextAlign.Center,
//                fontSize = 18.sp,
//                style = TextStyle(
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif
//                )
//            )

            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    /*onClose = { showTask = false },*/
                    modifier = modifier
                )
            }
            Text(
                text = "You've had $count glasses.",
                modifier = Modifier.padding(16.dp)
            )
        }
        Row(
            Modifier.padding(top = 10.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            
        ) {
            Button(
                onClick = {
                    count++
                    Log.d("WaterCounter", "$count")
                },
                enabled = count < 10,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Add One")
            }
            Button(
                onClick = { count = 0 },
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
            ) {
                Text(text = "Clear water count")
            }
        }
    }
}

@Preview
@Composable
fun WaterCounterPreview(){
    WaterCounter(modifier = Modifier)
}