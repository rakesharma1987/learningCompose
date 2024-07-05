package com.example.learningcompose.basicLayoutsCodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier

class BasicLayoutComposeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HomeSection(modifier = Modifier)
            MySootheAppPortrait()
        }
    }
}