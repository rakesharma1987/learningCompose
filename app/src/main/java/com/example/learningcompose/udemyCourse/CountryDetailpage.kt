package com.example.learningcompose.udemyCourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learningcompose.R
import com.example.learningcompose.udemyCourse.ui.retrieveCountryList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPage(navController: NavController, id: Int){
    val countryList = retrieveCountryList()
    val selectedCountry = countryList[id -1]
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Back")
                        
                    }
                },
                title = {Text(text = "Details", fontSize = 20.sp)},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                  containerColor = colorResource(id = R.color.purple_500),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White
                )
            )
        },
        content ={
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = selectedCountry.countryImage),
                    contentDescription = "Country Image",
                    modifier = Modifier.size(width = 250.dp, height = 200.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                    )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = selectedCountry.countryName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = selectedCountry.countryDetail,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }

        }
    )
}