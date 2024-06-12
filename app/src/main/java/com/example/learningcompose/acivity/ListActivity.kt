package com.example.learningcompose.acivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learningcompose.views.BlogCategoryPreview

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           BlogCategoryPreview(onItemClick = {
               Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
           })
        }
    }
}