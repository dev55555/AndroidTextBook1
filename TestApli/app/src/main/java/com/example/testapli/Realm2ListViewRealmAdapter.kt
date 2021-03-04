package com.example.testapli

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter

class Realm2ListViewRealmAdapter (data: OrderedRealmCollection<Realm2Model>?) : RealmBaseAdapter<Realm2Model>(data) {

    inner class ViewHolder(cell: View) {
        val id = cell.findViewById<TextView>(R.id.realm2ListId)
        val title= cell.findViewById<TextView>(R.id.realm2ListTitle)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: Realm2ListViewRealmAdapter.ViewHolder

        when (convertView) {
            null -> {
                val inﬂater = LayoutInflater.from(parent?.context)
                view = inﬂater.inflate(R.layout.realm2_list,
                        parent, false)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            }
            else -> {
                view = convertView
                viewHolder = view.tag as Realm2ListViewRealmAdapter.ViewHolder
            }
        }

        adapterData?.run {
            val titleList = get(position)
            Log.d("Realm2ListViewRealmAdapter", "titleList : ${ titleList.id.toString()}")
            Log.d("Realm2ListViewRealmAdapter", "titleList : ${titleList.title}")
            viewHolder.id.text = titleList.id.toString()
            viewHolder.title.text = titleList.title
        }
        return view
    }
}