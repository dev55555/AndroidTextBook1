package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dialog.*
import android.text.format.DateFormat
import java.util.*

class DialogActivity : AppCompatActivity()
    , AlertDialogImpl.OnClickListener
    , DatePickerDialogImpl.OnDateSelectedListener
    , TimePickerDialogImpl.OnTimeSelectedListener {

    private val TAG = "DialogActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        bt1.setOnClickListener {
            val dialog = AlertDialogImpl()
            dialog.show(supportFragmentManager, TAG)
            tv1.text = ""
            tv3.text = ""
        }

        // 日付
        tv3.setOnClickListener {
            val dialog = DatePickerDialogImpl()
            dialog.show(supportFragmentManager, TAG)
        }
        // 時刻
        tv4.setOnClickListener {
            val dialog = TimePickerDialogImpl()
            dialog.show(supportFragmentManager, TAG)
        }

    }
    override fun onNegativeClick() {
        tv1.text = "あと５分"
    }
    override fun onPositiveClick() {
        tv3.text = "起きる"
    }

    override fun onSelected(year: Int, month: Int, date: Int) {
        val c = Calendar.getInstance()
        c.set(year, month, date)
        tv3.text = DateFormat.format("yyyy/MM/dd", c)
    }

    override fun onSelected(hourOfDay: Int, minute: Int) {
        tv4.text = "%1$02d:%2$02d".format(hourOfDay, minute)
    }
}