package com.example.learningcompose.utility

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.learningcompose.model.Quotes
import com.example.learningcompose.model.UiContent
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quotes>()
    var sduiData = mutableListOf<UiContent>()
    var isDataLoading = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: Quotes? = null
    fun loadDataFromAsset(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quotes>::class.java)
        isDataLoading.value = true
    }

    fun loadUiDataFromAsset(context: Context){
        val inputStream = context.assets.open("serverDrivenUiResponse.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        sduiData = gson.fromJson(json, Array<UiContent>::class.java).toMutableList()

    }

    fun switchPages(quote: Quotes?){
        if (currentPage.value == Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }


}