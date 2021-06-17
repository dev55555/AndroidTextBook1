package com.example.worldclock

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextClock
import android.widget.TextView
import java.util.*


// タイムゾーンのリスト表示用アダプター
class TimeZoneAdapter(private val context: Context,
                      private val timeZones: Array<String> = TimeZone.getAvailableIDs())
    : BaseAdapter() {

    private val CLASS_NAME_TAG = "TimeZoneAdapter"

    private val inflater = LayoutInflater.from(context)

    // リストに表示する件数を返す
    override fun getCount() = timeZones.size

    // リストの位置に対応したタイムゾーンIDを返す
    override fun getItem(position: Int) = timeZones[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        Log.d(CLASS_NAME_TAG, "getViewメソッド")

        // convertViewがある場合はそれを使い、ない場合は新しく作る
        val view = convertView ?: createView(parent)

        // 以下、表示する値をセットしていく
        // positionから、表示すべきタイムゾーンのIDを得る
        val timeZoneId = getItem(position)
        // タイムゾーンIDから、タイムゾーンを得る
        val timeZone = TimeZone.getTimeZone(timeZoneId)

        // タグからViewHolderを取得
        val viewHolder = view.tag as ViewHolder

        // タイムゾーン名をセット
        @SuppressLint("SetTextI18n")
        viewHolder.name.text = "${timeZone.displayName}(${timeZone.id})"

        // タイムゾーンをセット
        viewHolder.clock.timeZone = timeZone.id

        return view
    }

    private fun createView(parent: ViewGroup?) : View {
        val view = inflater.inflate(R.layout.list_time_zone_row, parent, false)
        view.tag = ViewHolder(view)
        return view
    }

    // 各行のViewへの参照を持っておくことで、
    // 毎回findViewByIdをすることを避ける
    private class ViewHolder(view: View) {
        val name = view.findViewById<TextView>(R.id.timeZone)
        val clock = view.findViewById<TextClock>(R.id.clock)
    }
}