package com.example.learningcompose.basicLayoutsCodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MySoothAppLandscap(){
    Surface(color = MaterialTheme.colorScheme.background) {
        Row {
            SootheNavigationRail(modifier = Modifier)
            HomeSection(modifier = Modifier)
        }
    }
}

@Preview
@Composable
fun MySoothAppLandscapPreview(){
    MySoothAppLandscap()
}