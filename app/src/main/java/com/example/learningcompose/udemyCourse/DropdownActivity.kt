package com.example.learningcompose.udemyCourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningcompose.R
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class DropdownActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {
                DropDownComponent()
            }
        }
    }
}

@Composable
fun DropDownComponent(){
//    val selectedItem = remember {
//        mutableStateOf("Germany")
//    }

    val dropdownStatus = remember {
        mutableStateOf(false)
    }

//    val countryList = listOf("Germany", "England", "Italy", "India", "Belgium", "Finland", "Bulgeria", "Argentina")
    val countryList = stringArrayResource(id = R.array.country_list)
    val itemPosition = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box {
            Row(modifier = Modifier.clickable {
                dropdownStatus.value = true
            }) {
                Text(
//                    text =  selectedItem.value
                    countryList[itemPosition.value]
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_drop_down),
                    contentDescription = "drop down"
                )
            }

            DropdownMenu(
                expanded = dropdownStatus.value,
                onDismissRequest = {
                    dropdownStatus.value = false
                }
            ) {
                countryList.forEachIndexed{index, country ->
                    DropdownMenuItem(
                        text = { Text(text = country)},
                        onClick = {
                            dropdownStatus.value = false
                            itemPosition.value = index
                        })

                }

//                DropdownMenuItem(
//                    text = { Text(text = "Germany")},
//                    onClick = {
//                        dropdownStatus.value = false
//                        selectedItem.value = "Germany"
//                    })

//                DropdownMenuItem(
//                    text = { Text(text = "England")},
//                    onClick = {
//                        dropdownStatus.value = false
//                        selectedItem.value = "England"
//                    })
//
//                DropdownMenuItem(
//                    text = { Text(text = "Itlay")},
//                    onClick = {
//                        dropdownStatus.value = false
//                        selectedItem.value = "England"
//                    })
            }
        }

    }
}