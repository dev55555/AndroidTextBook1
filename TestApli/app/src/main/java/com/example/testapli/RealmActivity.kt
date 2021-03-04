package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_realm.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import java.util.*

class RealmActivity : AppCompatActivity() {
    private val CLASS_NAME_TAG = "RealmActivity"

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        realm = Realm.getDefaultInstance()

        // 保存処理
        bt1.setOnClickListener {
            Log.d(CLASS_NAME_TAG, "SAVE")
            // 画面からのテキストを保存する
            realm.executeTransaction {
                val id = et2.text.toString().toLong()
                val modelSchedule = realm.createObject<RealmModelSchedule>(id)
                modelSchedule.date = Date("2022/01/01")
                modelSchedule.title = et1.text.toString()
                modelSchedule.detail = "詳細"
            }
            alert("追加しました") {
                yesButton {
                }
            }.show()
            et1.setText("")
            et2.setText("")
            tv2.text = ""
            tv3.text = ""
        }

        // 検索
        bt2.setOnClickListener {
            Log.d(CLASS_NAME_TAG, "FIND")
            val modelSchedule = realm.where<RealmModelSchedule>().findFirst()
            if(modelSchedule != null) {
                Log.d(CLASS_NAME_TAG, "")
                tv2.text = modelSchedule.id.toString()
                tv3.text = modelSchedule.title
            } else {
                et1.setText("")
                et2.setText("")
                tv2.text = ""
                tv3.text = ""
            }
        }

        // 削除
        // 検索した１件のみを削除する
        bt3.setOnClickListener {
            Log.d(CLASS_NAME_TAG, "DELETE")

            val id = tv2.text.toString().toLong()

            realm.executeTransaction {
                val modelSchedule = realm.where<RealmModelSchedule>().equalTo("id", id).findAll()
                if(modelSchedule != null) {
                    Log.d(CLASS_NAME_TAG, "")
                    modelSchedule.deleteFirstFromRealm()
                }
            }
            alert("削除しました") {
                yesButton {
                }
            }.show()
            et1.setText("")
            et2.setText("")
            tv2.text = ""
            tv3.text = ""
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}