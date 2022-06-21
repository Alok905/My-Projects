package com.example.quizappalokkk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            if(etName.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name...", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
            }
        }
    }
}