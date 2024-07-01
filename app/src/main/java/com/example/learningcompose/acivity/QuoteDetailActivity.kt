package com.example.learningcompose.acivity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learningcompose.model.Quotes
import com.example.learningcompose.utility.KeyName
import com.example.learningcompose.views.QuoteDetail
import com.google.gson.Gson

class QuoteDetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val quote = intent.getSerializableExtra("AA") as Quotes
            QuoteDetail(quote)
        }
    }
}