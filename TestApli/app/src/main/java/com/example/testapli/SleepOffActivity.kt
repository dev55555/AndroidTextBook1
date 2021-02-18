package com.example.testapli

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.WindowManager.LayoutParams.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sleep_off.*

class SleepOffActivity : AppCompatActivity() {

    val CLASS_NAME_TAG = "SleepOffActivity"
    val SLEEP_OFF_TIME = 10000L

    inner class CountDownTimerImpl(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        // インターバル用のメソッド
        override fun onTick(millisUntilFinished: Long) {
            Log.d(CLASS_NAME_TAG, "onTick()")
        }
        // 終了時用のメソッド
        override fun onFinish() {
            Log.d(CLASS_NAME_TAG, "onFinish()")
            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ->
                    window.addFlags(FLAG_TURN_SCREEN_ON or FLAG_SHOW_WHEN_LOCKED)
                else ->
                    window.addFlags(FLAG_TURN_SCREEN_ON or FLAG_SHOW_WHEN_LOCKED or
                                    FLAG_DISMISS_KEYGUARD)
            }
            val intent = Intent(applicationContext, SleepOffActivity::class.java)
                .putExtra("onReceive", true)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            applicationContext.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_off)

        // 15秒のカウントダウンを行い、画面をオンにする
        val countDown = CountDownTimerImpl(SLEEP_OFF_TIME, 5000L)

        bt1.setOnClickListener {
            Toast.makeText(this, "${SLEEP_OFF_TIME/1000}秒後に画面をONにします。", Toast.LENGTH_LONG).show()
            countDown.start()
        }
    }
}