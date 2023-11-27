package com.example.mensescalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = findViewById<CalendarView>(R.id.cal_calendar)
        val checkBtn = findViewById<Button>(R.id.btn_check)
        val mencycle = findViewById<EditText>(R.id.editTextNumber)

        var currentChoice: LocalDate = LocalDate.now()
        var clicked = false
        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            clicked = true
            currentChoice = LocalDate.of(year, month, dayOfMonth)
            //Log.d("debug용", currentChoice)
        }
        calendar.setOnClickListener {


        }

        checkBtn.setOnClickListener {
            val menDate = mencycle.text.toString().toInt()
            if (mencycle.text.isEmpty()) {
                Toast.makeText(this, "생리주기를 적어주세요", Toast.LENGTH_SHORT).show()
                //mencycle.requestFocus()
                return@setOnClickListener
            }
            if (!clicked) {
                currentChoice = LocalDate.now()
            }
            val intent = Intent(this, ResultActivity::class.java)

            val bundle = Bundle()
            val localdate:String = currentChoice.toString()
            bundle.putString("currentChoice",localdate)
            bundle.putInt("menDate",menDate)
            startActivity(intent)

        }


    }


}