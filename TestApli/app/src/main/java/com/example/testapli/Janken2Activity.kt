package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_janken2.*
import org.jetbrains.anko.startActivity

class Janken2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_janken2)

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
        startActivity<Janken2ResultActivity>("MY_HAND" to view?.id)
    }
}