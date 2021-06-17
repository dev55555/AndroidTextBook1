package com.example.memo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

// メモ一覧用のフラグメント
class FilesListFragment : Fragment() {

    // メモをタップしたときのコールバックインターフェイス
    interface OnFilesSelectListener {
        fun onFileSelected(file: File)
    }

    private lateinit var recyclerView : RecyclerView

    // フラグメントがアクティビティにアタッチされたら呼ばれる
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // アクティビティがコールバックを実装していなかったら、例外を投げる
        if (context !is OnFilesSelectListener)
            throw RuntimeException("$context must implement OnFilesSelectListener")
    }

    // フラグメントのViewをつくって返す
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) : View {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view.findViewById(R.id.filesList)

        // 縦方向のリスト状に表示するレイアウマネージャを設定
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        show()

        return view
    }

    // メモの一覧を取得するローダーを起動する
    fun show() {
        // contextのnullチェック
        val ctx = context ?: return

        // メモの一覧を表示するためのAdapter
        val adapter = FilesAdapter(ctx, getFiles()) { file ->
            // タップされたら、コールバックを呼ぶ
            (context as OnFilesSelectListener).onFileSelected(file)
        }
        recyclerView.adapter = adapter
    }

}
