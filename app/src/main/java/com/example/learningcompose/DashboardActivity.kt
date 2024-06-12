package com.example.learningcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningcompose.acivity.ListActivity
import com.example.learningcompose.acivity.MainActivity
import com.example.learningcompose.acivity.QuoteListActivity
import com.example.learningcompose.acivity.ReCompositionActivity
import com.example.learningcompose.acivity.StateExampleActivity
import com.example.learningcompose.serverDrivenUI.DynamicUiActivity
import com.example.learningcompose.ui.theme.LearningComposeTheme
import com.example.learningcompose.views.DashboardUi

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
               }
           })
        }
    }
}