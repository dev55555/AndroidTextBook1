package com.example.eachsampleappv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout

class TabLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        // 動的にタブを実装
        // TabLayoutの生成
        val tabLayout = TabLayout(this).also {
            // 各Tabの生成
            val tab1 = it.newTab()
            tab1.setText("タブA")

            val tab2 = it.newTab()
            tab2.setText("タブB")

            val tab3 = it.newTab()
            tab3.setText("タブC")

            // 各TabをTabLayoutに追加
            it.addTab(tab1)
            it.addTab(tab2)
            it.addTab(tab3)
        }

        // TabLayoutをLinearLayoutに追加
        val container = findViewById<LinearLayout>(R.id.containerDynamic)
        container.addView(tabLayout)

    }
}