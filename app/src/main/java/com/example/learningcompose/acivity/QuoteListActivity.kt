package com.example.learningcompose.acivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.learningcompose.utility.DataManager
import com.example.learningcompose.utility.KeyName
import com.example.learningcompose.utility.Pages
import com.example.learningcompose.views.QuoteList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuoteListActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(100)
            DataManager.loadDataFromAsset(this@QuoteListActivity)
        }
        setContent {
            App()
        }
    }

    @Composable
    fun App(){
        val myContext = LocalContext.current
        if(DataManager.isDataLoading.value){
                QuoteList(DataManager.data, onClick = {
                    val intent = Intent(myContext, QuoteDetailActivity::class.java)
                    intent.putExtra("AA", it)
                    startActivity(intent)
                })
        }else{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center,
                ){
                    Text(
                        text = "Loading...",
                        style = MaterialTheme.typography.bodyMedium)
                }
        }
    }
}