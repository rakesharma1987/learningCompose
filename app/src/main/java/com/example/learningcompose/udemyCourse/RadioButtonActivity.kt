package com.example.learningcompose.udemyCourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class RadioButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RadioButtonComponent()
                }
            }
        }
    }
}


@Composable
fun RadioButtonComponent(){
    val myColor = remember {
        mutableStateOf(Color.White)
    }

    val radioIndex = remember {
        mutableStateOf(0)
    }

    val radioText = listOf("Red", "Green", "Yellow", "Blue")

    val colorList = listOf(Color.Red, Color.Green, Color.Yellow, Color.Blue)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = myColor.value)
            .padding(0.dp, 50.dp, 0.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(75.dp))
        Column {
            radioText.forEachIndexed { position, name ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        radioIndex.value = position
//                        myColor.value = colorList[position]
                    }) {
                    RadioButton(
                        selected = if (name == radioText[radioIndex.value]){
                            true
                        }else{
                            false
                        },
                        onClick = {
                            radioIndex.value = position
//                            myColor.value = colorList[position]
                        },
                        colors = RadioButtonDefaults.colors(Color.Blue)
                    )

                    Text(text = name, color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.size(50.dp))
        Button(
            onClick = {
                myColor.value = colorList[radioIndex.value]
            },
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(text = "Change Background Color")
        }
    }
}

@Preview
@Composable
fun RadioButtonComponentPreview(){
    RadioButtonComponent()
}