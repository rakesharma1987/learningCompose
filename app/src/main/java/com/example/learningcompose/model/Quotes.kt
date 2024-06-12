package com.example.learningcompose.model

import java.io.Serializable

data class Quotes(
    val text: String,
    val author: String
): Serializable
