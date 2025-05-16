package com.example.assignment2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val questions = intent.getStringArrayExtra("QUESTIONS")!!
        val answers = intent.getBooleanArrayExtra("ANSWERS")!!
        val listView = findViewById<ListView>(R.id.reviewList)

        val items = questions.mapIndexed { index, q ->
            "$q\nCorrect Answer: ${if (answers[index]) "True" else "False"}"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter =adapter
    }
}
