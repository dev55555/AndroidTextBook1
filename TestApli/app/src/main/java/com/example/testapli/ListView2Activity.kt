package com.example.testapli

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_list_view2.*

class ListView2Activity : AppCompatActivity() {

    private val APP_NAME = "ListView2"
    private val CALSS_NAME = "ListView2Activity"
    private val LOG_TAG = APP_NAME + CALSS_NAME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view2)

        // 表示データの作成
        val arrayTitleList = arrayOf(TitleList(1, "タイトル１"),
                                     TitleList(2, "タイトル２"),
                                     TitleList(3, "タイトル３"))
        Log.d(LOG_TAG, arrayTitleList.size.toString())

        val stringTitleList = arrayOf(arrayTitleList[0].toString(),
                                      arrayTitleList[1].toString(),
                                      arrayTitleList[2].toString())

        // ArrayAdapterの実装
        listView21.adapter = ArrayAdapter<String>(this,
                                                  R.layout.listview21_list,
                                                  R.id.listView21IdTitle,
                                                  stringTitleList)

        // BaseAdapterの実装
        listView22.adapter = TitleListAdapter(this,  arrayTitleList)

    }
}


class TitleList(val id : Long, val title : String) {

    override fun toString(): String {
        return "id=${id.toString()} | title=${title}"
    }
}

class TitleListAdapter(val context : Context, val titleLists : Array<TitleList>) : BaseAdapter() {

    private val APP_NAME = "ListView2"
    private val CALSS_NAME = "TitleListAdapter"
    private val LOG_TAG = APP_NAME + CALSS_NAME

    private val inflater = LayoutInflater.from(context)

    override fun getCount(): Int = titleLists.size
    override fun getItem(position: Int): Any = titleLists[position]
    override fun getItemId(position: Int): Long = titleLists[position].id
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // convertViewがある場合はそれを使い、ない場合は新しく作る
        val view = convertView ?: createView(parent)
        // positionから表示するModelオブジェクトを得る
        val titleListObj = getItem(position) as TitleList

        // タグからViewHolderを取得
        val viewHolder = view.tag as TitleListAdapter.ViewHolder

        // ViewHolderに値を設定する
        viewHolder.listViewId.text = titleListObj.id.toString()
        viewHolder.listViewTitle.text = titleListObj.title

        return view

    }

    private fun createView(parent: ViewGroup?) : View {
        val view = inflater.inflate(R.layout.listview22_list, parent, false)
        view.tag = ViewHolder(view)
        return view
    }

    // ViewHolderは、レイアウトのViewオブジェクトを持つ
    private class ViewHolder(view: View) {
        val listViewId: TextView = view.findViewById<TextView>(R.id.listView22Id)
        val listViewTitle: TextView = view.findViewById<TextView>(R.id.listView22Title)
    }
}