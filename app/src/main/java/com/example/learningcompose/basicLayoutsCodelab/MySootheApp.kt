package com.example.learningcompose.basicLayoutsCodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MySootheAppPortrait(){
    Scaffold (
        bottomBar = { SootheBottomNavigation()}
    ){padding ->
        HomeSection(Modifier.padding(padding))

    }

}

@Preview
@Composable
fun MySootheAppPortraitPreview(){
    MySootheAppPortrait()

}