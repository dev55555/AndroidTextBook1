package com.example.testapli

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_slideshow.*
import kotlin.concurrent.timer

class SlideshowActivity : AppCompatActivity() {

    // ImageSwitcherの実装方法
    // Ⅰー１
    private val resources = listOf(
        R.drawable.slide00, R.drawable.slide01,
        R.drawable.slide02, R.drawable.slide03,
        R.drawable.slide04, R.drawable.slide05,
        R.drawable.slide06, R.drawable.slide07,
        R.drawable.slide08, R.drawable.slide09
    )
    private var position = 0
    private var isSlideshow = false
    private val handler = Handler()

    private lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slideshow)

        // Ⅱー１
        imageSwitcher.setFactory {
            ImageView(this)
        }
        // 別の書き方
//        imageSwitcher.setFactory(ViewSwitcher.ViewFactory {
//            ImageView(this)
//        })

        // ImageSwitcherのオブジェクトに画像リソースを設定
        imageSwitcher.setImageResource(resources[position])

        prevButton.setOnClickListener {
            imageSwitcher.setInAnimation(this, android.R.anim.fade_in)
            imageSwitcher.setOutAnimation(this, android.R.anim.fade_out)
            movePosition(-1)
        }

        nextButton.setOnClickListener {
            imageSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
            imageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)
            movePosition(1)
        }

        timer(period = 5000) {
            handler.post {
                if (isSlideshow) movePosition(1)
            }
        }

        slideshowButton.setOnClickListener {
            isSlideshow = !isSlideshow
            when(isSlideshow) {
                true -> player.start()
                false -> player.apply {
                    pause()
                    seekTo(0)
                }
            }
        }

        player = MediaPlayer.create(this, R.raw.getdown)
        player.isLooping = true
    }

    // 画像変更のメソッド
    private fun movePosition(move: Int) {
        position += move
        if (position >= resources.size) {
            position = 0
        } else if (position < 0) {
            position = resources.size - 1
        }
        imageSwitcher.setImageResource(resources[position])
    }

}