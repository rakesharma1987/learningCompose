package com.example.learningcompose.views

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningcompose.R

@Preview
@Composable
fun ReComposePreview(){
    ReComposeView()
}

@Composable
fun ReComposeView(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = remember {
            mutableStateOf(1)
        }
        Log.d("ReComposeView", "Initial composition")

        Button(onClick = {
                state.value++
            }) {
                Text(text = "Count")
            }
        Log.d("ReComposeView", "ReCompose")
        Text(text = state.value.toString())

    }
}