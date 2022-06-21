package com.example.quizappalokkk

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_question.*
import java.lang.reflect.Type
import kotlin.properties.Delegates

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    var questionList: ArrayList<Questions> = ArrayList()
    var mCurrrentPage = 1
    var isSubmitClicked: Boolean = false
    var mSelectedOption: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionList = Constants.getQuestions()
        setUpQuestions()

        tv_option1.setOnClickListener(this)
        tv_option2.setOnClickListener(this)
        tv_option3.setOnClickListener(this)
        tv_option4.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }


    private fun setUpQuestions(){
        defaultOptionBG()
        tv_question.text = questionList[mCurrrentPage - 1].qus
        iv_img.setImageResource(questionList[mCurrrentPage - 1].img)
        pb_progress.progress = mCurrrentPage
        tv_progress.text = "${mCurrrentPage}/4"
        tv_option1.text = questionList[mCurrrentPage - 1].option1
        tv_option2.text = questionList[mCurrrentPage - 1].option2
        tv_option3.text = questionList[mCurrrentPage - 1].option3
        tv_option4.text = questionList[mCurrrentPage - 1].option4
        isSubmitClicked = false
        btnSubmit.text = "SUBMIT"
    }

    private fun defaultOptionBG(){
        val optionList: ArrayList<TextView> = ArrayList()
        optionList.add(0, tv_option1)
        optionList.add(1, tv_option2)
        optionList.add(2, tv_option3)
        optionList.add(3, tv_option4)

        for (option in optionList){
            option.typeface = Typeface.DEFAULT
            option.setTextColor(Color.parseColor("#ffffff"))
            option.setBackgroundResource(R.drawable.default_option_bg)
        }
    }

    private fun selectedOptionBG(view: TextView){
        defaultOptionBG()
        view.setTextColor(Color.parseColor("#000000"))
        view.setTypeface(view.typeface, Typeface.BOLD)
        view.setBackgroundResource(R.drawable.selected_option_bg)
    }

    private fun btnClicked(view: TextView){
        if(mSelectedOption == null) {
            mCurrrentPage++
            if(mCurrrentPage <= questionList.size){
                setUpQuestions()
            }
        }else{
            var correctOption: TextView? = null
            when (questionList[mCurrrentPage - 1].ansKey) {
                1 -> correctOption = tv_option1
                2 -> correctOption = tv_option2
                3 -> correctOption = tv_option3
                4 -> correctOption = tv_option4
            }
            correctOption!!.setBackgroundResource(R.drawable.correct_option_bg)
            if (correctOption != view) {
                view.setBackgroundResource(R.drawable.wrong_option_bg)
                view.setTextColor(Color.parseColor("#000000"))
            }
            isSubmitClicked = true
            mSelectedOption = null
            btnSubmit.text = "Go to next"
        }

    }


    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.tv_option1 -> {
                if(!isSubmitClicked) {
                    selectedOptionBG(tv_option1)
                    mSelectedOption = tv_option1
                }
            }
            R.id.tv_option2 -> {
                if(!isSubmitClicked) {
                    selectedOptionBG(tv_option2)
                    mSelectedOption = tv_option2
                }
            }
            R.id.tv_option3 -> {
                if(!isSubmitClicked) {
                    selectedOptionBG(tv_option3)
                    mSelectedOption = tv_option3
                }
            }
            R.id.tv_option4 -> {
                if(!isSubmitClicked) {
                    selectedOptionBG(tv_option4)
                    mSelectedOption = tv_option4
                }
            }
            R.id.btnSubmit -> {
                btnClicked(mSelectedOption!!)
            }
        }
    }
}