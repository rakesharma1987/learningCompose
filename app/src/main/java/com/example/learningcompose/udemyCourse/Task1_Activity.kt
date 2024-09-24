package com.example.learningcompose.udemyCourse

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class Task1_Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Components()
                }
            }
        }
    }
}

@Composable
fun Components(){
    val inputFirstName = remember {
        mutableStateOf("")
    }

    val inputLastName = remember {
        mutableStateOf("")
    }

    val getInputFirstName = remember {
        mutableStateOf("")
    }

    val getInputLastName = remember {
        mutableStateOf("")
    }

    val inputEmail = remember {
        mutableStateOf("")
    }

    val myImage = remember {
        mutableStateOf(R.drawable.jetpack_compose)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(0.dp, 50.dp, 0.dp, 10.dp),
        verticalArrangement = Arrangement.Top
    ){
        Box(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = myImage.value),
                contentDescription = "jetpack Compose",
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier.background(color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .size(100.dp)
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = inputFirstName.value,
            onValueChange = {
                inputFirstName.value = it
            },
            label = { Text(text = "Enter first name")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 50.dp, 5.dp, 5.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
//                focusedContainerColor = Color.White,
//                unfocusedContainerColor = Color.Gray,
//                focusedIndicatorColor = Color.Black,
//                unfocusedIndicatorColor = Color.Green
            ),
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences
            ),
            prefix = { Text(text = "Mr.")},
        )
        Spacer(modifier = Modifier.size(1.dp))
        TextField(
            value = inputLastName.value,
            onValueChange = {
                inputLastName.value = it
            },
            label = { Text(text = "Enter last name")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 0.dp, 5.dp, 5.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
//                focusedContainerColor = Color.White,
//                unfocusedContainerColor = Color.Gray,
//                focusedIndicatorColor = Color.Black,
//                unfocusedIndicatorColor = Color.Green
            ),
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        TextField(
            value = inputEmail.value,
            onValueChange = {
                inputEmail.value = it
            },
            label = { Text(text = "Enter email")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 0.dp, 5.dp, 5.dp)
                .border(1.dp, Color.Black, shape = RoundedCornerShape(0.dp))
                .background(color = Color.White, shape = RoundedCornerShape(0.dp)),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
//                focusedContainerColor = Color.White,
//                unfocusedContainerColor = Color.Gray,
//                focusedIndicatorColor = Color.Black,
//                unfocusedIndicatorColor = Color.Green
            ),
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences
            ),
//            shape = MaterialTheme.shapes.small
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
//            trailingIcon = { Icon(imageVector = Icons.Default.Clear, contentDescription ="")}
            trailingIcon = {
                if (inputEmail.value.isNotEmpty()){
                    IconButton(onClick = {inputEmail.value = ""}) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear text")
                    }
                }
            },
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            singleLine = true

        )
        Spacer(modifier = Modifier.size(50.dp))
        Box(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    getInputFirstName.value = inputFirstName.value
                    getInputLastName.value = inputLastName.value
                    myImage.value = R.drawable.female_avatar
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(10.dp)

            ) {
                Text(text = "Submit")
            }
        }

        Spacer(modifier = Modifier.size(50.dp))
        Box(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)){
            Text(
                text = getInputFirstName.value + " " + getInputLastName.value,
                modifier = Modifier.align(alignment = Alignment.Center),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}



@Preview
@Composable
fun ComponentsPreview(){
    Components()
}