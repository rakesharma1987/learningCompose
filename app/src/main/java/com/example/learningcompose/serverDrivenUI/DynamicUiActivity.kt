package com.example.learningcompose.serverDrivenUI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learningcompose.utility.DataManager
import com.example.learningcompose.views.BigCard.Display
import com.example.learningcompose.views.SDUIDisplayManager

class DynamicUiActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataManager.loadUiDataFromAsset(this)
        setContent {
//            Display(
//                btnTitle = "ABCD EFGH",
//                btnDescription = "askdjkskgjhnkskfnkdnfkgbnkfng",
//                horizontalPadding = 12,
//                verticalPadding = 16
//            )

            SDUIDisplayManager.Display(key = DataManager.sduiData.get(0).view_type, data = DataManager.sduiData.get(0).content.get(0))


        }
    }
}