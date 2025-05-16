package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class ScoreActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val questions = intent.getStringArrayExtra("QUESTIONS")
        val answers = intent.getBooleanArrayExtra("ANSWERS")

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewBtn = findViewById<Button>(R.id.reviewButton)
        val exitBtn = findViewById<Button>(R.id.exitButton)

        scoreText.text = "You scored: $score / 5"
        feedbackText.text = if (score >= 3) "Great job!" else "Keep practising!"

        reviewBtn.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("QUESTIONS", questions)
            intent.putExtra("ANSWERS", answers)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finishAffinity() // Exit app
        }
    }
}
