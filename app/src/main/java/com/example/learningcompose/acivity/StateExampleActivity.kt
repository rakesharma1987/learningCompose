package com.example.learningcompose.acivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learningcompose.views.NotificationCounterPreview

class StateExampleActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationCounterPreview()
        }
    }
}