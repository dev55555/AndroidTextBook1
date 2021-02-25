package com.example.testapli

import android.content.Context
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_off)

        // スリープを解除してダイアログを表示するサンプルコード




    }
}