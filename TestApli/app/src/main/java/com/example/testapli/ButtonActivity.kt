package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        // 昔の書き方
        val bt1 : Button = findViewById(R.id.button01)
        bt1.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v: View?) {
                    val textView : TextView = findViewById(R.id.textView01)
                    textView.setText(R.string.tv_morning)
                }
            }
        )
        // kotlin android extensionsを使用して、ID名を変数として使用可能
        // KotlinのSAM変換とラムダ式により、インタフェースの実装と処理を記述
        // Kotlinのプロパティによりオブジェクトのフィールド変数にgetter, setterを介さずにアクセスしている
        button02.setOnClickListener {
            textView01.text = getString(R.string.tv_afternoon)
        }
    }
}