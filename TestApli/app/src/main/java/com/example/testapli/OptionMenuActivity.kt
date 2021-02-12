package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class OptionMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu)
    }

    // オプションメニューの描画
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    // オプションメニューの処理の実装
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.btHome -> {
                // 処理
                Toast.makeText(this, "Home is tapped.", Toast.LENGTH_LONG).show()
            }
            R.id.btItem1 -> {
                // 処理
                Toast.makeText(this, "Item1 is tapped.", Toast.LENGTH_LONG).show()
            }
            R.id.btItem2 -> {
                // 処理
                Toast.makeText(this, "Item2 is tapped.", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}