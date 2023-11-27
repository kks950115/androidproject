package com.example.mensescalc


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val currentChoice = intent.getBundleExtra("currentChoice")
        val menDate = intent.getIntExtra("menDate",20)

        val ovulation = currentChoice
}