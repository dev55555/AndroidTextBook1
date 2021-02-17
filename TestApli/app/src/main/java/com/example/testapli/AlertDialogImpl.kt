package com.example.testapli

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import org.jetbrains.anko.toast

class AlertDialogImpl: DialogFragment() {

    interface OnClickListener {
        fun onNegativeClick()
        fun onPositiveClick()
    }

    private lateinit var listener: OnClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is AlertDialogImpl.OnClickListener) {
            listener = context
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = context
        if (context == null)
            return super.onCreateDialog(savedInstanceState)

        val builder = AlertDialog.Builder(this.activity!!).apply {
            setMessage("時間になりました！ ")
            setNegativeButton("あと５分") { dialog, which ->
                context.toast("あと５分がクリックされました。")
                listener.onNegativeClick()
            }
            setPositiveButton("起きる") { dialog, which ->
                context.toast("起きるがクリックされました。")
                listener.onPositiveClick()
            }
        }
        return builder.create()
    }
}