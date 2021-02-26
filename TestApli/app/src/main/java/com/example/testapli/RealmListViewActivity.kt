package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.content_schedule.*

class RealmListViewActivity : AppCompatActivity() {
    private val CLASS_NAME_TAG = "ListViewActivity"
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        realm = Realm.getDefaultInstance()
        val realmResultObj = realm.where<RealmModelSchedule>().findAll()
        if(realmResultObj != null) {
            listView.adapter = RealmListViewAdapter(realmResultObj)
        }
    }
}