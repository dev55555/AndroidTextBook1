package com.example.testapli

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Realm2ListViewAdapter(val context : Context,
                            val realmModelArray : Array<Realm2Model>)
    : BaseAdapter() {

    private val APP_NAME = "Realm2"
    private val CALSS_NAME = "Realm2ListViewAdapter"
    private val LOG_TAG = APP_NAME + CALSS_NAME

    private val inflater = LayoutInflater.from(context)

    override fun getCount() = realmModelArray.size

    override fun getItem(position: Int) = realmModelArray[position]

    override fun getItemId(position: Int) =  realmModelArray[position].id

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // convertViewがある場合はそれを使い、ない場合は新しく作る
        val view = convertView ?: createView(parent)

        // positionから表示するModelオブジェクトを得る
        val realm2ModelObject = getItem(position) as Realm2Model

        // タグからViewHolderを取得
        val viewHolder = view.tag as Realm2ListViewAdapter.ViewHolder

        // ViewHolderに値を設定する
        viewHolder.listViewId.text = realm2ModelObject.id.toString()
        viewHolder.listViewTitle.text = realm2ModelObject.title

        return view
    }

    private fun createView(parent: ViewGroup?) : View {
        val view = inflater.inflate(R.layout.realm2_list, parent, false)
        view.tag = ViewHolder(view)
        return view
    }

    // ViewHolderは、レイアウトのViewオブジェクトを持つ
    private class ViewHolder(view: View) {
        val listViewId = view.findViewById<TextView>(R.id.realm2ListId)
        val listViewTitle = view.findViewById<TextView>(R.id.realm2ListTitle)
    }

}

