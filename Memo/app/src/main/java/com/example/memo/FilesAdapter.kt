package com.example.memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class FilesAdapter(private val context: Context,
                   private val files: List<File>, // ファイルの一覧
                   private val onFileClicked: (File) -> Unit) // タップ時のコールバック
    : RecyclerView.Adapter<FilesAdapter.FileViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    // Viewに表示すべき値を設定する
    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        val file = files[position]
        // ファイル名の表示
        holder.title.text = file.name
        // 最終更新日時の表示
        holder.updatedTime.text = context.getString(R.string.last_modified, file.lastModified())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        val view = inflater.inflate(R.layout.list_item_row, parent, false)
        val viewHolder = FileViewHolder(view)

        view.setOnClickListener {
            // タップされた位置に対応したメモを得る
            val file = files[viewHolder.adapterPosition]
            // コールバックを呼ぶ
            onFileClicked(file)
        }
        return viewHolder
    }

    override fun getItemCount() = files.size

    class FileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title)
        val updatedTime = view.findViewById<TextView>(R.id.lastModified)
    }
}