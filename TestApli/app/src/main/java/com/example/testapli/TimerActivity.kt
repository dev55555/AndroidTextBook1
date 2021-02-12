package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        var isOn = false

        bt1.setOnClickListener{
            isOn = !isOn
            Toast.makeText(this, "isOn:${isOn}", Toast.LENGTH_SHORT).show()
            Log.d("TimerActivity", "isOn:${isOn}")
        }

//        bt1.setOnClickListener(
//            View.OnClickListener {
//                isOn = !isOn
//                Toast.makeText(this, "isOn:${isOn}", Toast.LENGTH_LONG)
//                Log.d("TimerActivity", "isOn:${isOn}")
//            }
//        )

    }
}