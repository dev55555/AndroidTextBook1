package com.example.testapli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent.*
import org.jetbrains.anko.startActivity

class IntentActivity : AppCompatActivity() {
    val CLASS_NAME_TAG = "IntentActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        // Intentオブジェクトの取得による実装例
        btNext.setOnClickListener {
            val intent = Intent(this, IntentNextActivity::class.java)
            intent.putExtra("INPUT_NAME", et1.text.toString())
            this.startActivity(intent)
        }

        // Ankoの使用によるintentの記述の簡略化例
        btNext2.setOnClickListener {
//            startActivity<IntentNextActivity>(Pair("INPUT_NAME", et1.text.toString()))
            startActivity<IntentNextActivity>("INPUT_NAME" to et1.text.toString())
        }
    }
}