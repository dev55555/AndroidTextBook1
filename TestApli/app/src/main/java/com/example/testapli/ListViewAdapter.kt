package com.example.testapli

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(private val context : Context,
                      private val listViewModelArray : Array<ListViewModel>)
    : BaseAdapter() {
    private val CLASS_NAME_TAG = "TimeZoneAdapter"
    private val inflater = LayoutInflater.from(context)

    override fun getCount() = listViewModelArray.size

    override fun getItem(position: Int): Any = listViewModelArray[position]

    override fun getItemId(position: Int): Long = listViewModelArray[position].id

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // convertViewがある場合はそれを使い、ない場合は新しく作る
        val view = convertView ?: createView(parent)

        // positionから表示するModelオブジェクトを得る
        val listViewModelObj = getItem(position) as ListViewModel

        // タグからViewHolderを取得
        val viewHolder = view.tag as ViewHolder

        // ViewHolderに値を設定する
        viewHolder.listViewId.text = listViewModelObj.id.toString()
        viewHolder.listViewTitle.text = listViewModelObj.title

        return view
    }

    private fun createView(parent: ViewGroup?) : View {
        val view = inflater.inflate(R.layout.list_view_sample, parent, false)
        view.tag = ViewHolder(view)
        return view
    }

    // ViewHolderは、レイアウトのViewオブジェクトを持つ
    private class ViewHolder(view: View) {
        val listViewId = view.findViewById<TextView>(R.id.listViewId)
        val listViewTitle = view.findViewById<TextView>(R.id.listViewTitle)
    }

}