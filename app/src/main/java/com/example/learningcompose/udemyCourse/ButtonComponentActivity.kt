package com.example.learningcompose.udemyCourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class ButtonComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                ButtonComponents()
            }
        }
    }
}


@Composable
fun ButtonComponents() {
    val myButtonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val myButtonText = remember {
        mutableStateOf("Do your magic")
    }

    val myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }

    val myText = remember {
        mutableStateOf("Hello World")
    }

    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }

    val buttonStatus = remember {
        mutableStateOf(true)
    }

    val onValueChanged = remember {
        mutableStateOf("")
    }

    val userInput = remember {
        mutableStateOf("")
    }

    val inputTfEmail = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = myText.value,
            color = myTextColor.value,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Red)
        )

        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = {
                    if (buttonStatus.value) {
                        myButtonBackgroundColor.value = Color.Black
                        myButtonText.value = "Compose is fun"
                        myButtonTextColor.value = Color.Red
                        myText.value = "Hello Compose"
                        myTextColor.value = Color.White
                        buttonStatus.value = false
                    }else{
                        myButtonBackgroundColor.value = Color.White
                        myButtonText.value = "Do Your Magic"
                        myButtonTextColor.value = Color.Black
                        myText.value = "Hello World"
                        myTextColor.value = Color.Black
                        buttonStatus.value = true
                    }
                userInput.value = onValueChanged.value
                onValueChanged.value = ""

            },
            modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = myButtonBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.size(30.dp))

        TextField(
            value = onValueChanged.value,
            onValueChange = {
                onValueChanged.value = it
            },
            label = { Text(text = "Enter your name")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
                cursorColor = Color.Black
            ),
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            visualTransformation = PasswordVisualTransformation(),
            prefix = {Text(text = "+91 ")}

        )

        TextField(
            value = inputTfEmail.value,
            onValueChange = {
                inputTfEmail.value = it
            },
            label = { Text(text = "Enter your email")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
                cursorColor = Color.Black
            ),
            textStyle = TextStyle.Default.copy(fontSize = 16.sp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
//            prefix = {
//                Image(painter = Paint().sha, contentDescription = )
//            }
        )

        Spacer(modifier = Modifier.size(30.dp))

        Text(
            text = userInput.value
        )


    }
}

@Preview(showBackground = true)
@Composable
fun ButtonComponentsPreview() {
    ButtonComponents()
}