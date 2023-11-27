package com.example.mbtitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class TestActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    val questionnaireResults =  QuestionnaireResults()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this)
        viewPager.isUserInputEnabled = false //화면을 터치로 옆으로 넘기면 다음 페이지가 나오는 기능을 막겠다. 모든 질문이 선택되야 옮기게 구현할 것이기 떄문에 필요없음
    }

    fun moveToNextQuestion(){
        if(viewPager.currentItem==3){
            //마지막 페이지 -> 결과 화면으로 이동
            var intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("results",ArrayList(questionnaireResults.results))
            startActivity(intent)
        }else{
            val nextItem = viewPager.currentItem+1
            if(nextItem < viewPager.adapter?.itemCount?: 0){
                viewPager.setCurrentItem(nextItem,true)
            }
        }
    }
}

class QuestionnaireResults {
    val results = mutableListOf<Int>()

    fun addResponses(response: List<Int>){ // 1,2,2...
        var mostFragment = response.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
        mostFragment?.let { results.add(it) }
    }
}