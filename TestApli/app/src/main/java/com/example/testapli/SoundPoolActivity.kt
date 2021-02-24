package com.example.testapli

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sound_pool.*

class SoundPoolActivity : AppCompatActivity() {
    private val TAG = "SoundPoolActivity"

    private lateinit var soundPool: SoundPool
    private var soundResId = 0
    private var soundStreamId = 0
    private var isPlay = false

    private var soundResId2 = 0

    override fun onResume() {
        super.onResume()

        // Deprecated未対応
        // soundPool = SoundPool(2, AudioManager.STREAM_ALARM, 0)

        // Deprecated対応
        soundPool =
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                Log.d(TAG, "if")
                @Suppress("DEPRECATION")
                SoundPool(2, AudioManager.STREAM_ALARM, 0)
            } else {
                Log.d(TAG, "else")
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                SoundPool.Builder()
                    .setMaxStreams(2)
                    .setAudioAttributes(audioAttributes)
                    .build()
            }
            soundResId = soundPool.load(this, R.raw.pond, 1)
            soundResId2 = soundPool.load(this, R.raw.cuculuscry, 1)

    }

    override fun onPause() {
        super.onPause()
        soundPool.release()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_pool)

        bt1.setOnClickListener{
            soundStreamId = soundPool.play(soundResId, 1.0f, 1.0f, 0, -1, 1.0f)
            tv1.text = getString(R.string.tv_play)
            isPlay = true
        }

        bt2.setOnClickListener{
            soundPool.play(soundResId2, 1.0f, 1.0f, 0, 0, 1.0f)
        }

        bt3.setOnClickListener{
            when(isPlay) {
                true -> {
                    soundPool.pause(soundStreamId)
                    tv1.text = getString(R.string.tv_pause)
                    isPlay = !isPlay
                }
                false -> {
                    soundPool.resume(soundStreamId)
                    tv1.text = getString(R.string.tv_play)
                    isPlay = !isPlay
                }
            }
        }

        bt4.setOnClickListener {
            soundPool.stop(soundStreamId)
            tv1.text = getString(R.string.tv_stop)
            isPlay = false
        }
    }
}