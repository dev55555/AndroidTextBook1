package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_spinner.*

class SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        // 本1の実装方法
        spinner1.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spinner = parent as? Spinner
                    val item = spinner?.selectedItem as? String
                    item?.let {
                        if (it.isNotEmpty()) textView1.text = it
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

        // Android developersの実装方法
        val spinner2: Spinner = findViewById(R.id.spinner2)
        // string-arrayでArrayAdapterを作成、またレイアウトの設定もしている。
        ArrayAdapter.createFromResource(
            this,
            R.array.list_spinner2,
            android.R.layout.simple_spinner_item
        ).also {
            arrayAdaptor ->  arrayAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = arrayAdaptor
        }
        // ユーザー選択への応答
        spinner2.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val spinner = parent as? Spinner
                    val item = spinner?.selectedItem as? String
                    item?.let {
                        if (it.isNotEmpty()) textView1.text = it
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

        // Spinnerに作成した配列を設定するサンプル
        val items = arrayOf("選択肢Ａ", "選択肢Ｂ", "選択肢Ｃ")
        val arrayAdaptor = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items)
//        val arrayAdaptor = ArrayAdapter.createFromResource(this, R.array.list_spinner2, android.R.layout.simple_spinner_item)
        arrayAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner3.adapter = arrayAdaptor

        spinner3.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                ) {
                    val spinner = parent as? Spinner
                    val item = spinner?.selectedItem as? String
                    item?.let {
                        if (it.isNotEmpty()) textView1.text = it
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

    }
}