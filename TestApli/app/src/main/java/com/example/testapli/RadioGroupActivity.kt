package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_radio_group.*

class RadioGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_group)


        rGroup.setOnCheckedChangeListener { group, checkedId ->
            checkedId
            textView31.text = findViewById<RadioButton>(checkedId).text
        }

    }

//    fun onRadioButtonClicked(view: View) {
//        if (view is RadioButton) {
//            // Is the button now checked?
//            val checked = view.isChecked
//
//            // Check which radio button was clicked
//            when (view.getId()) {
//                R.id.rBtn1 ->
//                    if (checked) {
//                        textView31.text = rBtn1.text
//                    }
//                R.id.rBtn2 ->
//                    if (checked) {
//                        textView31.text = rBtn2.text
//                    }
//                R.id.rBtn3 ->
//                    if (checked) {
//                        textView31.text = rBtn3.text
//                    }
//            }
//        }
//    }
}