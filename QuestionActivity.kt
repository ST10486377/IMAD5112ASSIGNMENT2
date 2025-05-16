package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "The Great Wall of China is visible from the moon",
        "World War I began in 1939",
        "The Roman Empire fell in 476 AD",
        "The pyramids were built by aliens"
    )
    private val answers = arrayOf(true, false, false, true, false)
    private var currentQuestion = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionText = findViewById<TextView>(R.id.questionText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val trueBtn = findViewById<Button>(R.id.trueBtn)
        val falseBtn = findViewById<Button>(R.id.falseBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        questionText.text = questions[currentQuestion]

        @SuppressLint("SetTextI18n")
        fun checkAnswer(userAnswer: Boolean) {
            val correct = answers[currentQuestion]
            if (userAnswer == correct) {
                feedbackText.text = "Correct!"
                score++
                Log.d("Quiz", "Question ${currentQuestion + 1} answered correctly.")
            } else {
                feedbackText.text = "Incorrect"
                Log.d("Quiz", "Question ${currentQuestion + 1} answered incorrectly.")
            }
        }

        trueBtn.setOnClickListener { checkAnswer(true) }
        falseBtn.setOnClickListener { checkAnswer(false) }

        nextBtn.setOnClickListener {
            currentQuestion++
            if (currentQuestion < questions.size) {
                questionText.text = questions[currentQuestion]
                feedbackText.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("QUESTIONS", questions)
                intent.putExtra("ANSWERS", answers)
                startActivity(intent)
                finish()
            }
        }
    }
}
