package com.example.testapli

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sound_pool.*

class SoundPoolActivity : AppCompatActivity() {

    private lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        player = MediaPlayer.create(this, R.raw.bellsound)
        player.isLooping = true

        bt1.setOnClickListener{
            player.start()
        }

        bt2.setOnClickListener {
            player.apply {
                pause()
                seekTo(0)
            }
        }
    }
}