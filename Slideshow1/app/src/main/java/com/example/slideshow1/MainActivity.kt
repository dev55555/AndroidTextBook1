package com.example.slideshow1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewPropertyAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener {
            it.animate().apply {
                duration = 3000L
                rotation(360.0f * 5.0f)
            }
        }

        imageView2.setOnClickListener(View.OnClickListener {
            val obj : ViewPropertyAnimator = it.animate()
            obj.duration = 3000L
            obj.rotation(360.0f * -2.0f)
        })

        val listener : View.OnClickListener = View.OnClickListener() {
            if(it != null) {
                val obj : ViewPropertyAnimator = it.animate()
                obj.duration = 3000L
                obj.rotation(360.0f * 2.0f)
            }
        }
        imageView3.setOnClickListener(listener)

    }
}