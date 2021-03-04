package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // 表示するデータの作成
        val listViewModelObj1 = ListViewModel(1, "Title1")
        val listViewModelObj2 = ListViewModel(2, "Title2")
        val listViewModelObj3 = ListViewModel(3, "Title3")
        val listViewModelObj4 = ListViewModel(4, "Title4")
        val listViewModelObj5 = ListViewModel(5, "Title5")
        val listViewModelObjArray = arrayOf(listViewModelObj1,
                                            listViewModelObj2,
                                            listViewModelObj3,
                                            listViewModelObj4,
                                            listViewModelObj5)

        // ListViewのadapterプロパティにAdapterのオブジェクトを設定する
        listView.adapter = ListViewAdapter(this, listViewModelObjArray)
    }
}