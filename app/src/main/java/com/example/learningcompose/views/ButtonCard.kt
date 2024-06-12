package com.example.learningcompose.views

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object ButtonCard {
    @Composable
    fun Display(
        btnTitle: String,
        horizontalPadding: Int,
        verticalPadding: Int
    ){
        Column(
            modifier = Modifier
                    .padding(horizontal = horizontalPadding.dp, vertical = verticalPadding.dp)
        ) {
            Card(
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .width(100.dp)
                    .height(100.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontalPadding.dp, verticalPadding.dp),
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Image,
                        contentDescription = "image Big",
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = btnTitle,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(fontSize = 18.sp)
                    )

                }

            }
        }
    }
}