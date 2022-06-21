package com.example.quizappalokkk

object Constants {

    fun getQuestions(): ArrayList<Questions>{
        val questionList: ArrayList<Questions> = ArrayList()
        var question = Questions( "What season does this image belong to ?", 1, R.drawable.winter,
            "Autumn", "Winter", "Rainy", "Summer", 2)
        questionList.add(question)
        question = Questions( "What season does this image belong to ?", 2,
            R.drawable.autumn, "Autumn", "Winter", "Rainy", "Summer", 1)
        questionList.add(question)
        question = Questions("What season does this image belong to ?", 3,
            R.drawable.rainy, "Autumn", "Winter", "Rainy", "Summer", 3)
        questionList.add(question)
        question = Questions("What season does this image belong to ?", 4,
            R.drawable.summer, "Autumn", "Winter", "Rainy", "Summer", 4)
        questionList.add(question)

        return questionList
    }
}