package com.example.eachsampleappv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun callTabLayoutActivity(view: View) {
        val intent = Intent(this, TabLayoutActivity::class.java)
        startActivity(intent)
    }

}