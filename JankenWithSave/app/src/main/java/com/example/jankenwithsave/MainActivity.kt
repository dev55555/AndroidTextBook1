package com.example.jankenwithsave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // イベントリスナを設定
        gu.setOnClickListener { onJankenButtonTapped(it) }
        choki.setOnClickListener { onJankenButtonTapped(it) }
        pa.setOnClickListener { onJankenButtonTapped(it) }

        //
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.clear().apply()
    }

    // ボタンを押した時に実行するメソッド
    fun onJankenButtonTapped(view: View?) {
        // org.jetbrains.anko.startActivityを使用して、1行にした
        startActivity<ResultActivity>("MY_HAND" to view?.id)
    }
}