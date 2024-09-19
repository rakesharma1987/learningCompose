package com.example.learningcompose.views

import android.content.ClipData.Item
import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.learningcompose.R
import com.example.learningcompose.model.Items

object DashboardUi {

    @Composable
    fun MyButtons(onClick: (Items) -> Unit){
        LazyColumn(content = {
            items(getDashboardItems()){item ->
                ButtonUi(
                    item.name,
                    onButtonClick = onClick
                )
            }
        })
    }


    @Composable
    fun ButtonUi(name: String, onButtonClick: (Items)->Unit){
        Button(
            onClick = {
                      onButtonClick(Items(name))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 0.dp, 5.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.light_black)
            )
        ) {
            Text(
                text = name
            )
        }
    }

    fun getDashboardItems(): MutableList<Items>{
        val dashboardItems = mutableListOf<Items>()
        dashboardItems.add(Items( "ListActivity"))
        dashboardItems.add(Items( "MainActivity"))
        dashboardItems.add(Items("ReCompositionActivity"))
        dashboardItems.add(Items("StateExampleActivity"))
        dashboardItems.add(Items("QuoteListActivity"))
        dashboardItems.add(Items("DynamicUiActivity"))
        dashboardItems.add(Items("BasicLayoutComposeActivity"))
        dashboardItems.add(Items("WellnessActivity"))

        return dashboardItems
    }
}