package com.example.learningcompose.basicLayoutsCodelab

import android.util.Log
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MySootheApp(windowSize: WindowSizeClass){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        when(windowSize.widthSizeClass){
            WindowWidthSizeClass.Compact ->{
                MySootheAppPortrait()
                Log.d("MySootheApp", "Compact")

            }
            WindowWidthSizeClass.Medium ->{
                MySoothAppLandscap()
                Log.d("MySootheApp", "Medium")
            }
            WindowWidthSizeClass.Expanded ->{
                MySoothAppLandscap()
                Log.d("MySootheApp", "Expand")
            }
        }
    }

}