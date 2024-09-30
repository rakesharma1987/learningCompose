package com.example.learningcompose.udemyCourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class ActionbarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopAppBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(){
    val actionText = remember {
        mutableStateOf("action will be shown here")
    }
    val menuStatus = remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        actionText.value = "Navigation Icon Clicked"
                    }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                title = {
                    Column {
                        Text(text = stringResource(id = R.string.app_name), color = Color.White, fontSize = 20.sp)
                        Text(text = "subtitle", color = Color.White, fontSize = 16.sp)
                    }
                },
                actions = {
                    IconButton(onClick = { actionText.value = "Share Icon Clicked" }) {
                        Icon(imageVector = Icons.Filled.Share, contentDescription = "Menu")
                    }

                    IconButton(onClick = { actionText.value = "Search Icon Clicked" }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Menu")
                    }

                    IconButton(
                        onClick = {
//                            actionText.value = "More Icon Clicked"
                            menuStatus.value = true
                        }) {
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu")

                        DropdownMenu(
                            expanded = menuStatus.value,
                            onDismissRequest = {menuStatus.value = false}) {
                            
                            DropdownMenuItem(
                                text = { Text(text = "Settings") },
                                onClick = {
                                    actionText.value = "Settings clicked"
                                    menuStatus.value = false
                                })
                            DropdownMenuItem(
                                text = { Text(text = "Logout") },
                                onClick = {
                                    actionText.value = "Logout clicked"
                                    menuStatus.value = false
                                })
                        }
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                )
            )
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = actionText.value, color = Color.Black, fontSize = 20.sp)
            }
        }
    )
}