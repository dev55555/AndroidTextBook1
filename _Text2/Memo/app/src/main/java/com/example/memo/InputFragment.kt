package com.example.memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.io.File

// メモ入力用のフラグメント
class InputFragment : Fragment() {

    // メモ保存時のコールバックインターフェイス
    interface OnFileOutputListener {
        fun onFileOutput()
    }

    private var currentFile : File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null && savedInstanceState.containsKey("file")) {
            currentFile = File(savedInstanceState.getString("file"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        currentFile?.let {
            outState.putString("file", it.absolutePath)
        }
    }

    // フラグメントのレイアウトを作成して返す
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)
            ?: return null

        // メモ入力用のEditText
        val content = view.findViewById<EditText>(R.id.content)
        // 保存ボタン
        val saveButton = view.findViewById<Button>(R.id.save)

        saveButton.setOnClickListener {
            // メモを保存する
            currentFile = outputFile(currentFile, content.text.toString())

            if (context is OnFileOutputListener) {
                (context as OnFileOutputListener).onFileOutput()
            }
        }

        return view
    }

    fun show(file: File) {
        // ファイルを読み込む
        val memo = inputFile(file)

        // 表示を更新する
        val content = view?.findViewById<EditText>(R.id.content) ?: return
        content.setText(memo)

        currentFile = file
    }
}
