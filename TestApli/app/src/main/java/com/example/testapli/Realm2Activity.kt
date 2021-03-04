package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_realm2.*

class Realm2Activity : AppCompatActivity() {

    private val APP_NAME = "Realm2"
    private val CALSS_NAME = "Realm2Activity"
    private val LOG_TAG = APP_NAME + CALSS_NAME

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm2)

        realm = Realm.getDefaultInstance()

        btRealm2Resist.setOnClickListener {
            Log.d(LOG_TAG, "登録")

            realm.executeTransaction {
                var editTextString = realm2IdEt1.text.toString()
                if(editTextString.equals("")) {
                    Log.d(LOG_TAG, "id未入力")
                    editTextString = "1"
                    realm2IdEt1.setText(editTextString)
                }
                val id = editTextString.toLong()
                val modelObj = realm.createObject<Realm2Model>(id)
                modelObj.title = realm2TitleEt1.text.toString()
            }
            Toast.makeText(this, "登録しました。", Toast.LENGTH_SHORT).show()
            realm2IdEt1.setText("")
            realm2TitleEt1.setText("")
        }
        btRealm2Search.setOnClickListener {
            Log.d(LOG_TAG, "検索")
            realm.executeTransaction {
                var editTextString = realm2IdEt2.text.toString()
                if(editTextString.equals("")) {
                    Log.d(LOG_TAG, "id未入力")
                    editTextString = "1"
                    realm2IdEt2.setText(editTextString)
                }
                val id = editTextString.toLong()
                val modelObj = realm.where<Realm2Model>().equalTo("id", id).findFirst()
                if(modelObj != null) {
                    Log.d(LOG_TAG, "検索結果：有り")
                    realm2TitleTv2.text = modelObj.title
                } else {
                    Log.d(LOG_TAG, "検索結果：無し")
                    realm2TitleTv2.text = "Not Found"
                }
            }
            Toast.makeText(this, "検索しました。", Toast.LENGTH_SHORT).show()
        }
        btRealm2Delete.setOnClickListener {
            Log.d(LOG_TAG, "削除")
            realm.executeTransaction {
                var editTextString = realm2IdEt2.text.toString()
                if(editTextString.equals("")) {
                    Log.d(LOG_TAG, "id未入力")
                    editTextString = "1"
                    realm2IdEt2.setText(editTextString)
                }
                val id = editTextString.toLong()
                val modelObj = realm.where<Realm2Model>().equalTo("id", id).findAll()
                if(modelObj != null) {
                    modelObj.deleteFirstFromRealm()
                    Toast.makeText(this, "削除しました。", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "削除できませんでした。", Toast.LENGTH_SHORT).show()
                }
            }
            realm2IdEt2.setText("")
            realm2TitleTv2.text = ""
        }
        btRealm2ListSearch.setOnClickListener {
            Log.d(LOG_TAG, "一覧検索")
            realm.executeTransaction {
                val realmResults = realm.where<Realm2Model>().findAll()
                realm2ListView1.adapter = Realm2ListViewAdapter(this, realmResults.toTypedArray())
                Log.d(LOG_TAG, "一覧検索の結果の件数：${realmResults.size}")
            }
            Toast.makeText(this, "一覧検索しました。", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}