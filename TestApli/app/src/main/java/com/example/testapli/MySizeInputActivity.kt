package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Spinner
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_my_size_app.*
import kotlinx.android.synthetic.main.activity_my_size_input.*
import org.jetbrains.anko.startActivity

class MySizeInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_size_input)
        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override
                fun onItemSelected(parent: AdapterView<*>?,
                                   view: View?,
                                   position: Int,
                                   id: Long) {
                    val spinner = parent as? Spinner
                    val item = spinner?.selectedItem as? String
                    item?.let {
                        if (it.isNotEmpty()) height.text = it
                    }
                }
                override
                fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

        PreferenceManager.getDefaultSharedPreferences(this).apply {
            val heightVal = getInt("HEIGHT", 160)
            height.setText(heightVal.toString())
            seekBar.progress = heightVal
        }

        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?,
                                               progress: Int,
                                               fromUser: Boolean) {
                    height.text = progress.toString()
                }

                override
                fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override
                fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            checkedId
            height.text = findViewById<RadioButton>(checkedId).text
        }
    }

    override fun onPause() {
        super.onPause()
        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putInt("HEIGHT", height.text.toString().toInt())
            .apply()
    }
}