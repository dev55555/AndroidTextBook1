package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_my_size_app.*
import org.jetbrains.anko.startActivity

class MySizeAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_size_app)


        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        // スコープ関数のapplyを未使用
        val editNeck = pref.getString("NECK", "")
        neck.setText(editNeck)
        // スコープ関数のapplyの使用例１
        pref.apply {
            // prefオブジェクトへthisでアクセス可能
            val editSleeve = this.getString("SLEEVE", "")
            sleeve.setText(editSleeve)
            // thisは省略可能
            val editWaist = getString("WAIST", "")
            waist.setText(editWaist)
            // １行にできる
            inseam.setText(getString("INSEAM", ""))
        }

        // さらに省略すると、、
//        PreferenceManager.getDefaultSharedPreferences(this).apply {
//            neck.setText(getString("NECK", ""))
//            sleeve.setText(getString("SLEEVE", ""))
//            waist.setText(getString("WAIST", ""))
//            inseam.setText(getString("INSEAM", ""))
//        }

        save.setOnClickListener { onSaveTapped() }

        heightButton.setOnClickListener {
            startActivity<MySizeInputActivity>()
        }

    }

    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("NECK", neck.text.toString())
            .putString("SLEEVE", sleeve.text.toString())
            .putString("WAIST", waist.text.toString())
            .putString("INSEAM", inseam.text.toString())
            .apply()
    }
}