package com.example.testuse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    Solution("14523","23452")
}

class Solution {
    fun solution(X: String, Y: String): String {
        var answer: String = ""

        var x = X
        var y = Y
        for(i in X.indices){
            for(j in Y.indices){
                if(x[i]==y[j]){
                    x=x.replace(y[j],"")
                    y=y.replace(y[j],"")
                    answer+=y[j]
                }
            }
        }
        answer=answer.split("").sortedDescending().joinToString("")
        if(answer.length==0){
            answer="-1"
        }
        if(answer.toInt()==0){
            answer="0"
        }
        return answer
    }
}


