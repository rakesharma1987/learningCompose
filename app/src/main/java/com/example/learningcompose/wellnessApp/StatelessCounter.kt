package com.example.learningcompose.wellnessApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(count: Int, onIncrement: ()-> Unit, modifier: Modifier) {
    Column(modifier.padding(8.dp)) {
        if (count > 0) {
            Text(
                text = "You had $count of glasses"
            )
            
            Button(onClick = onIncrement, modifier = Modifier.padding(top = 8.dp), enabled = count < 10) {
                Text(text = "Add one")
            }
        }
    }

}

@Composable
fun StatefulCounter(modifier: Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++}, modifier)

}

@Preview
@Composable
fun StatefulCounterPreview(){
    StatefulCounter(modifier = Modifier)
}