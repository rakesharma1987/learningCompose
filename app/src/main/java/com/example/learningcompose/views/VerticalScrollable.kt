package com.example.learningcompose.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

object VerticalScrollable {
    @Composable
    fun Display(data: List<Any>) {
        Column(content = {
            data.map {
                SDUIDisplayManager.Display(data = it)
            }
        })
    }
}