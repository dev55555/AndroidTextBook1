package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hello_android_app.*

class HelloAndroidAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_android_app)

        bt1.setOnClickListener {
            textView.text = "ボタンがタップされました。"
        }
    }
}