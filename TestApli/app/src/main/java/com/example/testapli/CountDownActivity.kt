package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDownActivity : AppCompatActivity() {

    val CLASS_NAME_TAG = "CountDownActivity"

    inner class CountDownTimerImpl(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        override fun onTick(millisUntilFinished: Long) {
            Log.d(CLASS_NAME_TAG, "onTick()")
            tv1.text = "onTick()"
        }

        override fun onFinish() {
            Log.d(CLASS_NAME_TAG, "onFinish()")
            tv1.text = "onFinish()"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)

        // 15秒のカウントダウンを行い、4秒ごとに何かを行う
        val countDown = CountDownTimerImpl(15000, 4000)

        bt1.setOnClickListener {
            Log.d(CLASS_NAME_TAG, "start()")
            tv1.text = "start()"
            countDown.start()
        }

        bt2.setOnClickListener {
            Log.d(CLASS_NAME_TAG, "cancel()")
            tv1.text = "cancel()"
            countDown.cancel()
        }
    }
}