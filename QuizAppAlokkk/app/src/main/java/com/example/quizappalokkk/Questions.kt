package com.example.quizappalokkk

data class Questions (
    var qus: String,
    val id: Int,
    var img: Int,
    var option1: String,
    var option2: String,
    var option3: String,
    var option4: String,
    var ansKey: Int
)