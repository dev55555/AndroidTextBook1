package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_floating_action_button.*

class FloatingActionButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_action_button)

        // play is true
        // stop is false
        var isPlay: Boolean = false

        floatingActionButton.setOnClickListener(
            View.OnClickListener {
                Log.d("FloatingActionButtonActivity", "floatingActionButton.setOnClickListener")
                when(isPlay) {
                    true -> {
                        isPlay = false
                        textView.text = getString(R.string.tv_stop)
                        floatingActionButton.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                        Snackbar.make(it, "The music has stopped.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .show()
                    }
                    false -> {
                        isPlay = true
                        textView.text = getString(R.string.tv_play)
                        floatingActionButton.setImageResource(R.drawable.ic_baseline_stop_24)
                        Snackbar.make(it, "The music has started.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .show()
                    }
                }
            }
        )
    }
}