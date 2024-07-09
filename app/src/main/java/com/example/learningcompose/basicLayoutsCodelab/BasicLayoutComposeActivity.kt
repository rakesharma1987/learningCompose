package com.example.learningcompose.basicLayoutsCodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier

class BasicLayoutComposeActivity: ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HomeSection(modifier = Modifier)
//            MySootheAppPortrait()

            val windowSize = calculateWindowSizeClass(this@BasicLayoutComposeActivity)
            MySootheApp(windowSize)
        }

    }

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onResume() {
        super.onResume()
        setContent {
//            HomeSection(modifier = Modifier)
//            MySootheAppPortrait()

            val windowSize = calculateWindowSizeClass(this@BasicLayoutComposeActivity)
            MySootheApp(windowSize)
        }
    }
}