package com.example.testapli

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_media_player.*

class MediaPlayerActivity : AppCompatActivity() {

    private lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        player = MediaPlayer.create(this, R.raw.getdown)
        player.isLooping = true

        bt1.setOnClickListener{
            player.start()
        }

        bt4.setOnClickListener {
            player.apply {
                pause()
                seekTo(0)
            }
        }
    }
}