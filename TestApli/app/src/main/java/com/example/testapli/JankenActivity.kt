package com.example.testapli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_janken.*

class JankenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_janken)

        // イベントリスナを設定
        gu.setOnClickListener { onJankenButtonTapped(it) }
        choki.setOnClickListener { onJankenButtonTapped(it) }
        pa.setOnClickListener { onJankenButtonTapped(it) }
    }

    // ボタンを押した時に実行するメソッド
    fun onJankenButtonTapped(view: View?) {
        val intent = Intent(this, JankenResultActivity::class.java)
        intent.putExtra("MY_HAND", view?.id)

        if( null == intent.resolveActivity(packageManager)) {
            Log.d("NULL確認", "nullだった")
        } else {
            Log.d("NULL確認", "nullではない")
        }

        this.startActivity(intent)
    }
}