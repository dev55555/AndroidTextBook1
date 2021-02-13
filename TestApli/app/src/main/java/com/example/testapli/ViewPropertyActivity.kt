package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewPropertyAnimator
import kotlinx.android.synthetic.main.activity_view_property.*

class ViewPropertyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_property)

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

        val listener3 : View.OnClickListener = View.OnClickListener() {
            if(it != null) {
                val obj : ViewPropertyAnimator = it.animate()
                obj.duration = 3000L
                obj.rotation(360.0f * 2.0f)
            }
        }
        imageView3.setOnClickListener(listener3)

        val listener4 : View.OnClickListener = View.OnClickListener() {
            it.animate().apply {
                duration = 3000L
                scaleX(2.5f)
                scaleY(2.5f)
            }
        }
        imageView4.setOnClickListener(listener4)

        imageView5.setOnClickListener {
            it.animate().apply {
                duration = 3000L
                x(200.0f)
                y(200.0f)
            }
        }

    }
}