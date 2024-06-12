package com.example.learningcompose.views

import android.graphics.drawable.Icon
import android.media.Image
import android.view.Display
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.model.UiContent

object BigCard {
    @Composable
    fun Display(
        btnTitle: String,
        btnDescription: String,
        horizontalPadding: Int,
        verticalPadding: Int
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = horizontalPadding.dp, vertical = verticalPadding.dp)
        ) {
            Card(
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontalPadding.dp, verticalPadding.dp),
                ) {
                    Text(
                        text = btnTitle,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(fontSize = 18.sp)
                    )
                    Divider()
                    Icon(
                        imageVector = Icons.Outlined.Image,
                        contentDescription = "image Big",
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                    )
                    Text(
                        text = btnDescription,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(fontSize = 14.sp)
                    )


                }

            }
        }
    }
}