package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リストで表示するタイムゾーンの一覧
        val timeZones = TimeZone.getAvailableIDs()
        Log.d("MainActivity", "合計：${timeZones.size}")

        // リストをレイアウトから探す
        val listView = findViewById<ListView>(R.id.timeZoneList)

        // アダプターを作成
        val adapter = ArrayAdapter<String>(this,
                R.layout.list_time_zone_row,
                R.id.timeZone,
                timeZones)

        // リストにアダプターをセットする
        listView.adapter = adapter

        // リストのアイテムタップ時の動作
        listView.setOnItemClickListener { parent, view, position, id ->
            // アダプターから、押された位置のタイムゾーンを得る
            val timeZone = adapter.getItem(position)
            // Toastで表示
            Toast.makeText(this, timeZone, Toast.LENGTH_SHORT).show()
        }
    }
}