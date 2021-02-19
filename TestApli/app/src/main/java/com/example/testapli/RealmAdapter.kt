package com.example.testapli

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter

class RealmAdapter(data: OrderedRealmCollection<RealmModelSchedule>?):
        RealmBaseAdapter<RealmModelSchedule>(data) {

    inner class ViewHolder(cell: View) {
        val date = cell.findViewById<TextView>(android.R.id.text1)
        val title = cell.findViewById<TextView>(android.R.id.text1)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        when (convertView) {
            null -> {
                val inﬂater = LayoutInflater.from(parent?.context)
                view = inﬂater.inflate(android.R.layout.simple_list_item_2,
                    parent, false)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            }
            else -> {
                view = convertView
                viewHolder = view.tag as RealmAdapter.ViewHolder
            }
        }

        adapterData?.run {
            val schedule = get(position)
            viewHolder.date.text =
                DateFormat.format("yyyy/MM/dd", schedule.date)
            viewHolder.title.text = schedule.title
        }
        return view
    }
}