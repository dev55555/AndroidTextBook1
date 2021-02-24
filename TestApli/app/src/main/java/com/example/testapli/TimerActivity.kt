package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_timer.*
import java.util.*
import kotlin.concurrent.timer

class TimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        var isOn = false
        lateinit var timerMonitor: Timer

        // timer関数１
        // 実行時にViewオブジェクトを変更するとエラーとなるケース
        bt1.setOnClickListener{
            isOn = !isOn
            Log.d("TimerActivity", "isOn:${isOn}")
            timerMonitor = timer(period = 2000) {
                Log.d("TimerActivity", "timer関数の使用")
                // tv1.text = "${tv1.text}＞" // 実行時エラー
            }
        }
        bt2.setOnClickListener{
            isOn = !isOn
            Log.d("TimerActivity", "isOn:${isOn}")
            timerMonitor.cancel()
            tv1.text = getString(R.string.tv_TimerActivity)
        }
        // タイトル変更のボタン
        bt3.setOnClickListener{
            tv1.text = ""
        }

        // timer関数２
        // 実行時にViewオブジェクトを変更するとエラーとならないケース
        val handler = Handler()
        bt4.setOnClickListener{
            isOn = !isOn
            Log.d("TimerActivity", "isOn:${isOn}")
            timerMonitor = timer(period = 2000) {
                Log.d("TimerActivity", "timer関数とHandlerクラスの使用")
                handler.post {
                    tv1.text = "${tv1.text}＞"
                }
            }
        }
    }
}