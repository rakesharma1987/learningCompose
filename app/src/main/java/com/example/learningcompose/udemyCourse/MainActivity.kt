package com.example.learningcompose.udemyCourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {

//                    Greeting(
//                        name = "Android"
//                    )
                MyLayout()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Box(modifier = Modifier
            .background(Color.Red)
            .width(200.dp)
            .height(200.dp)) {

            Row {
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue))
            Column {
                Column {
                    Text(
                        text = "Hello"
                    )

                    Text(
                        text = name
                    )
                }
            }
            }
        }
    }
}

@Composable
fun MyLayout(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
//        horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically
//        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Red)
                .padding(30.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        Text(
            text = "Android Studio",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Red)
                .width(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    Greeting(name = "Android")

    MyLayout()
}