package com.example.learningcompose.views

import android.view.Display
import androidx.compose.runtime.Composable
import com.example.learningcompose.model.Content
import com.example.learningcompose.model.Datas
import com.example.learningcompose.model.UiContent

object SDUIDisplayManager {
    @Composable
    fun Display(data: Any){
        when(data){
            is Content ->{
                Display(key = data.view_type, data = data)
            }
        }
    }

    @Composable
    fun Display(key: String, data: Any) = when(key){
        "buttonCard" ->{
            val content = data as Content
            val data = content.data
            ButtonCard.Display(
                btnTitle = data.title,
                horizontalPadding = content.horizontal_padding,
                verticalPadding = content.vertical_padding
            )
        }

        "row" ->{
            val content = data as UiContent
            HorizontalScrollable.Display(data = content.content)
        }

        "column" ->{
            val content = data
//            VerticalScrollable.Display(data)
        }

        "bigCard" ->{
            val content = data as Content
            val data = content.data
            BigCard.Display(data.title, data.description, content.horizontal_padding, content.vertical_padding)
        }

        else -> Unit
    }
}