package com.example.learningcompose.acivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learningcompose.utility.DataManager
import com.example.learningcompose.utility.KeyName
import com.example.learningcompose.views.QuoteList

class QuoteListActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataManager.loadDataFromAsset(this)
        setContent {
            QuoteList(DataManager.data, onClick = {
                val intent = Intent(this, QuoteDetailActivity::class.java)
                intent.putExtra(KeyName.quote, it)
                startActivity(intent)
            })
        }
    }
}