package com.example.bogapp.app.tasks.taskInformation

import com.example.bogapp.R
import com.example.bogapp.app.Models.TaskTestModel
import com.example.bogapp.app.tasks.taskTest

class Info() {


    fun getQuestions(): ArrayList<TaskTestModel> {

        val tasks = ArrayList<TaskTestModel>()

        val answer1 = TaskTestModel(
            0,
            "Какое время используется в предложении?",
            "I talked to John yesterday.",
            R.drawable.times,
            "Present Simple",
            "Past Simple",
            "Present Future",
            "Past Future",
            1
        )

        tasks.add(answer1)

        val answer2 = TaskTestModel(
            1,
            "Что такое осень, на английском?",
            "",
            R.drawable.fall,
            "Плачущее небо под ногами",
            "Summer",
            "Fall",
            "Winter",
            1
        )

        tasks.add(answer2)

        val answer3 = TaskTestModel(
            2,
            "Translate this sentence to Russian",
            "I love you.",
            R.drawable.love,
            "Мама, я хочу кушать",
            "Папа, я гуляю",
            "Я люблю тебя",
            "Какая погода?",
            2
        )

        tasks.add(answer3)

        val answer4 = TaskTestModel(
            3,
            "Переведи текст на англйский",
            "Который час?",
            R.drawable.time,
            "Is this your watch?",
            "Can I help you?",
            "Do you want to sleep?",
            "What time is it?",
            3
        )

        tasks.add(answer4)

        val answer5 = TaskTestModel(
            4,
            "Переведи на русский",
            "How's it going?",
            R.drawable.girl,
            "Как дела?",
            "Ты занят?",
            "Мама, у нас есть покушать?",
            "Ты куда идешь?",
            0
        )

        tasks.add(answer5)

        val answer6 = TaskTestModel(
            5,
            "Ответь на вопрос",
            "Is this your guitar?",
            R.drawable.guitar,
            "Yes, I want",
            "Yes, it is mine",
            "No, I don't want",
            "No, I'm not hungry",
            1
        )

        tasks.add(answer6)

        val answer7 = TaskTestModel(
            6,
            "Какое время используется в предложении?",
            "How long time have you been learning English?",
            R.drawable.times,
            "Present Simple",
            "Present continuous",
            "Present Perfect",
            "Present Perfect Continuous",
            3
        )

        tasks.add(answer7)

        return tasks

    }
}