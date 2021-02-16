package com.example.testapli

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_media_player.*

class MediaPlayerActivity : AppCompatActivity() {
    private val TAG = "MediaPlayerActivity"

    private lateinit var mediaPlayer: MediaPlayer
    private var isPlay = false

    override fun onResume() {
        super.onResume()
        mediaPlayer = MediaPlayer.create(this, R.raw.getdown)
        mediaPlayer.isLooping = true
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.release()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        bt1.setOnClickListener{
            mediaPlayer.start()
            isPlay = true
        }

        bt3.setOnClickListener {
            when(isPlay) {
                true -> {
                    mediaPlayer.pause()
                    isPlay = !isPlay
                }
                false -> {
                    mediaPlayer.start()
                    isPlay = !isPlay
                }
            }
        }

        bt4.setOnClickListener {
            mediaPlayer.apply {
                stop()
                prepare()
            }
            isPlay = false
        }
    }
}