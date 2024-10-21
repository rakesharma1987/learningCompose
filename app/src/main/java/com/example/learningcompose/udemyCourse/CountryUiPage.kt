package com.example.learningcompose.udemyCourse

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learningcompose.R
import com.example.learningcompose.udemyCourse.ui.retrieveCountryList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstPage(navController: NavController){

    val countryList = retrieveCountryList()
    val myContext = LocalContext.current
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = {
                    Text(text = "Country List", color = Color.White)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(it)
            ) {
                items(
                    count = countryList.size,
                    itemContent = {index ->
                        val country = countryList[index]

                        //Card
                        Card(
                            onClick = {
                                Toast.makeText(myContext, country.countryName, Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.fillMaxWidth()
                                .height(120.dp)
                                .padding(5.dp),
                            colors = CardDefaults.cardColors(containerColor = colorResource(R.color.purple_500)),
                            shape = RoundedCornerShape(10.dp),
                            elevation = CardDefaults.cardElevation(7.dp),
                            border = BorderStroke(2.dp, Color.Red)

                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize().padding(7.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Image(
                                        painter = painterResource(id = country.countryImage),
                                        contentDescription = country.countryName,
                                        modifier = Modifier
                                            .size(60.dp)
                                            .clip(RoundedCornerShape(100))
                                            .border(3.dp, color = Color.Red, shape = RoundedCornerShape(100)),
                                        contentScale = ContentScale.Crop,
                                        alignment = Alignment.Center
                                    )

                                    Column (
                                        modifier = Modifier.padding(7.dp)
                                    ){
                                        Text(
                                            text = country.countryName,
                                            fontSize = 18.sp,
                                            color = Color.White,

                                            )
                                        Spacer(modifier = Modifier.padding(1.dp))
                                        Text(
                                            text = country.countryDetail,
                                            fontSize = 12.sp,
                                            color = Color.White,
                                        )
                                    }

                                }
                                Button(
                                    onClick = {
                                        navController.navigate("CountryDetailpage/${country.countryId}")
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                    border = BorderStroke(1.dp, color = Color.Red)
                                ) {
                                    Icon(
                                        Icons.Rounded.ArrowForward,
                                        contentDescription = "icon",
                                        tint = Color.Red
                                    )
                                }
                            }

                        }
                    }
                )
            }
        }
    )
}