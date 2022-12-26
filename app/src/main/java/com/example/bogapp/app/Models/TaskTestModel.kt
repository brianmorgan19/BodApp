package com.example.bogapp.app.Models

import android.graphics.drawable.Drawable
import android.widget.ImageView

class TaskTestModel(
    val taskID:Int,
    val task: String,
    val question: String,
    val image: Int,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val isCorrect:Int
                    )