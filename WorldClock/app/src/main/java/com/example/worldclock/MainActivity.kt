package com.example.worldclock

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ユーザーのデフォルトタイムゾーンを取得する
        val timeZone = TimeZone.getDefault()

        // タイムゾーン名を表示するTextView
        val timeZoneView = findViewById<TextView>(R.id.timeZone)
        // タイムゾーン名を表示
        timeZoneView.text = timeZone.displayName

        // 「追加する」ボタンをレイアウトから探す
        val addButton = findViewById<Button>(R.id.add)
        // 「追加する」ボタンがタップされたら、タイムゾーン選択画面に遷移する
        addButton.setOnClickListener {
            val intent = Intent(this, TimeZoneSelectActivity::class.java)
            // 遷移先画面での結果を受け取りたい場合
            startActivityForResult(intent, 1)
        }

        // 世界時計のリストを表示する
        showWorldClocks()
    }

    // タイムゾーン選択画面での結果を受けとる
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 // リクエストコードが一致している
                && resultCode == Activity.RESULT_OK // 結果がRESULT_OKである
                && data != null) { // データがnullではない
            // 受け取ったデータから、タイムゾーンを得る
            val timeZone = data.getStringExtra("timeZone")

            // プリファレンスから、保存しているタイムゾーンを得る
            val pref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            val timeZones = pref.getStringSet("time_zone", mutableSetOf())?.toMutableSet()
                    ?: mutableSetOf()

            // 保存していたタイムゾーン一覧に追加
            timeZones.add(timeZone)

            // プリファレンスに保存する
            pref.edit().putStringSet("time_zone", timeZones.toSet()).apply()

            // リストを再表示する
            showWorldClocks()
        }
    }

    // 世界時計のリストを表示する
    private fun showWorldClocks() {
        // プリファレンスから、保存しているタイムゾーンを得る
        val pref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val timeZones = pref.getStringSet("time_zone", null) ?: setOf()

        val list = findViewById<ListView>(R.id.clockList)
        list.adapter = TimeZoneAdapter(this, timeZones.toTypedArray())
    }
}