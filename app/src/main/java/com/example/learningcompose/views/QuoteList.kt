package com.example.learningcompose.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.learningcompose.model.Quotes

@Composable
fun QuoteList(data: Array<Quotes>, onClick: (Quotes)->Unit){
    LazyColumn(content = {
        items(data){
            QuotesItem(quotes = it) {
                onClick(it)
            }
        }
    })

}