package com.example.learningcompose.acivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learningcompose.basicLayoutsCodelab.BasicLayoutComposeActivity
import com.example.learningcompose.serverDrivenUI.DynamicUiActivity
import com.example.learningcompose.views.DashboardUi
import com.example.learningcompose.wellnessApp.WellnessActivity

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           DashboardUi.MyButtons(onClick = {
               when(it.name){
                   "ListActivity" ->{
                        startActivity(Intent(this, ListActivity::class.java))
                   }
                   "MainActivity" ->{
                       startActivity(Intent(this, MainActivity::class.java))
                   }
                   "ReCompositionActivity" ->{
                       startActivity(Intent(this, ReCompositionActivity::class.java))
                   }
                   "StateExampleActivity" ->{
                       startActivity(Intent(this, StateExampleActivity::class.java))
                   }
                   "QuoteListActivity" ->{
                       startActivity(Intent(this, QuoteListActivity::class.java))
                   }
                   "DynamicUiActivity" ->{
                       startActivity(Intent(this, DynamicUiActivity::class.java))
                   }
                   "BasicLayoutComposeActivity" ->{
                       startActivity(Intent(this, BasicLayoutComposeActivity::class.java))
                   }
                   "WellnessActivity" ->{
                       startActivity(Intent(this, WellnessActivity::class.java))
                   }
               }
           })
        }
    }
}