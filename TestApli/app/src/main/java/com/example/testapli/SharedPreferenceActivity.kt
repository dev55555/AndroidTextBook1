package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // 画面を開いたときに、すでに共有プリファレンスに値があれば、TextViewに表示する
        val sharedPreferncesObj = PreferenceManager.getDefaultSharedPreferences(this)
        val et1String = sharedPreferncesObj.getString("NAME", "DEFAULT VALUE")
        tv1.text = et1String

        btResist.setOnClickListener {
            val sharedPreferencesEditor = sharedPreferncesObj.edit()
            sharedPreferencesEditor.putString("NAME", et1.text.toString())
            sharedPreferencesEditor.apply()
            Toast.makeText(this, "${et1.text.toString()}を登録しました。", Toast.LENGTH_SHORT).show()
        }

        btRemove.setOnClickListener {
            val sharedPreferencesEditor = sharedPreferncesObj.edit().apply {
                clear()
                apply()
            }
            Toast.makeText(this, "${tv1.text.toString()}を消去しました。", Toast.LENGTH_SHORT).show()
            tv1.text = ""
        }
    }
}