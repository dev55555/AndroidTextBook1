package com.example.testapli

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.WindowManager.LayoutParams.*
import kotlinx.android.synthetic.main.activity_sleep_off.*
import java.util.*

class SleepOffActivity : AppCompatActivity() {
    val ACTIVITY_NAME = "SleepOffActivity"
    val CLASS_NAME_TAG = "SleepOffActivity"
    val LOG_MESSAGE = ACTIVITY_NAME + "："
    val SLEEP_OFF_TIME = 10000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bt1のスリープ解除後の処理
        // BroadcastReceiverで、スタートしたアクティビティのウィンドウを新たに開いている
        if (intent?.getBooleanExtra("onReceive", false) == true) {
            Log.d(CLASS_NAME_TAG, LOG_MESSAGE + "スリープ解除後の処理を開始")
            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ->
                    window.addFlags(FLAG_TURN_SCREEN_ON or
                            FLAG_SHOW_WHEN_LOCKED)
                else ->
                    window.addFlags(FLAG_TURN_SCREEN_ON or
                            FLAG_SHOW_WHEN_LOCKED or FLAG_DISMISS_KEYGUARD)
            }
        }

        setContentView(R.layout.activity_sleep_off)
        // スリープを解除してダイアログを表示するサンプルコード
        // AlarmManagerとBroadcastReceiverでの実装例
        bt1.setOnClickListener {
            val calendar = Calendar.getInstance()
            Log.d(CLASS_NAME_TAG, LOG_MESSAGE + calendar.toString())

            val sleepOffTime = calendar.timeInMillis + SLEEP_OFF_TIME
            calendar.time = Date(sleepOffTime)
            Log.d(CLASS_NAME_TAG, LOG_MESSAGE + calendar.toString())

            val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, SleepOffBroadcastReceiver::class.java)
            val pending = PendingIntent.getBroadcast(this, 0, intent, 0)
            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                    val info = AlarmManager.AlarmClockInfo(
                            calendar.timeInMillis, null)
                    am.setAlarmClock(info, pending)
                }
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT -> {
                    am.setExact(AlarmManager.RTC_WAKEUP,
                            calendar.timeInMillis, pending)
                }
                else -> {
                    am.set(AlarmManager.RTC_WAKEUP,
                            calendar.timeInMillis, pending)
                }
            }
            // ボタンをタップしたあと、当アクティビティを閉じないでアラームの指定時間になると
            // 当画面の上に新たなSleepOffActivity画面が表示されてしまうので、
            // とりあえず、ボタンをタップした時点で、この画面を閉じる
            finish()
        }

//        // カウントダウンでの画面表示は上手くいかない？
//        bt2.setOnClickListener {
//            val countDownTimer = CountDownTimerImpl(SLEEP_OFF_TIME, 1000L)
//            countDownTimer.start()
//        }
    }

//    inner class CountDownTimerImpl(millisInFuture: Long, countDownInterval: Long) :
//            CountDownTimer(millisInFuture, countDownInterval) {
//        override fun onTick(millisUntilFinished: Long) {
//            Log.d(CLASS_NAME_TAG, LOG_MESSAGE + "インターバル中")
//        }
//        override fun onFinish() {
//            Log.d(CLASS_NAME_TAG, LOG_MESSAGE + "カウントダウン終了")
//
//            when {
//                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ->
//                    window.addFlags(FLAG_TURN_SCREEN_ON or
//                            FLAG_SHOW_WHEN_LOCKED)
//                else ->
//                    window.addFlags(FLAG_TURN_SCREEN_ON or
//                            FLAG_SHOW_WHEN_LOCKED or FLAG_DISMISS_KEYGUARD)
//            }
//        }
//    }

}