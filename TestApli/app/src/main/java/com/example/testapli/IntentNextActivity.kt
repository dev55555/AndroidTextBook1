package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_next.*
import org.jetbrains.anko.startActivity

class IntentNextActivity : AppCompatActivity() {
    val CLASS_NAME_TAG = "IntentNextActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_next)

        // データの取り出し
        tv1.text = this.intent.getStringExtra("INPUT_NAME")

        btBack.setOnClickListener {
            this.finish()
        }
    }
}