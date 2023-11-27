package com.example.my_bmi_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getDoubleExtra("height",0.0)
        val weight = intent.getDoubleExtra("weight",0.0)

        var value = weight/(height/100).pow(2)
        value = round(value*10)/10

        var resultText = ""
        var resImage = 0
        var resColor = 0

        if(value < 18.5){
            resultText="저체중"
            resColor = Color.YELLOW
            resImage = R.drawable.level1
        }else if(value>=18.5 && value <23.0 ){
            resultText="정상 체중"
            resColor = Color.GREEN
            resImage = R.drawable.level2
        }else if(value>=23.0 && value <25.0 ){
            resultText="과체중"
            resColor = Color.BLUE
            resImage = R.drawable.level3
        }else if(value>=25.5 && value <30.0 ){
            resultText="경도 비만"
            resColor = Color.MAGENTA
            resImage = R.drawable.level4
        }else if(value>=30.0 && value <35.0 ){
            resultText="중도 비만"
            resColor = Color.CYAN
            resImage = R.drawable.level5
        }else {
            resultText="고도 비만"
            resColor = Color.RED
            resImage = R.drawable.level6
        }

        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val tv_img = findViewById<ImageView>(R.id.tv_img)
        val btn_back = findViewById<Button>(R.id.btn_back)
        tv_resValue.text = value.toString()
        tv_resText.text = resultText
        tv_resText.setTextColor(resColor)
        tv_img.setImageResource(resImage)

        btn_back.setOnClickListener {
            finish()
        }
    }
}