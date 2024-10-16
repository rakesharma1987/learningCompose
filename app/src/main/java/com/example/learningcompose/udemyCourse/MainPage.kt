package com.example.learningcompose.udemyCourse

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learningcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController){
    val userName = remember {
        mutableStateOf("")
    }
    val userAge = remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = {
                    Text(text = "Main page", color = Color.White)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        },
        content = {paddingValue ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValue),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    TextField(
                        value = userName.value,
                        onValueChange = {
                            userName.value = it
                        },
                        label = { Text(text = "Enter your name")},
                        colors = TextFieldDefaults.textFieldColors(
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            containerColor = colorResource(id = R.color.purple_500)
                        ),
                        modifier = Modifier.size(300.dp, 60.dp),
                        textStyle = TextStyle(fontSize = 18.sp, color = Color.White),
                        shape = RoundedCornerShape(5.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(10.dp))

                    TextField(
                        value = userAge.value,
                        onValueChange = {
                            userAge.value = it
                        },
                        label = { Text(text = "Enter your age")},
                        colors = TextFieldDefaults.textFieldColors(
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            containerColor = colorResource(id = R.color.purple_500)
                        ),
                        modifier = Modifier.size(300.dp, 60.dp),
                        textStyle = TextStyle(fontSize = 18.sp, color = Color.White),
                        shape = RoundedCornerShape(5.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    
                    Button(onClick = {
                            navController.navigate(route = "SecondPage"){
//                                popUpTo("MainPage"){inclusive = true}
                            }
                      },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        modifier = Modifier.size(200.dp, 60.dp),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp, color = colorResource(id = R.color.purple_500))
                        ) {
                        Text(
                            text = "Send",
                            color = colorResource(id = R.color.white)
                        )
                        
                    }

                }
        }
    )
}