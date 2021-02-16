package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_image_switcher.*
import kotlinx.android.synthetic.main.activity_image_switcher.imageSwitcher

class ImageSwitcherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_switcher)

        // ImageSwitcherのオブジェクトにImageViewのオブジェクトを持てる準備をした。
        imageSwitcher.setFactory {
            ImageView(this)
        }

        // ImageSwitcherのオブジェクトに画像リソースを設定
        imageSwitcher.setImageResource(R.drawable.slide00)

        // ボタンが押されたら、ImageSwitcherのオブジェクトに別の画像リソースを設定
        bt1.setOnClickListener(
            View.OnClickListener {
                imageSwitcher.setImageResource(R.drawable.slide01)
            }
        )
        bt4.setOnClickListener(
            View.OnClickListener {
                imageSwitcher.setImageResource(R.drawable.slide02)
            }
        )
        // 画面切り替え時にアニメーションを設定
        bt4.setOnClickListener(
            View.OnClickListener {
                imageSwitcher.setInAnimation(this, android.R.anim.fade_in)
                imageSwitcher.setOutAnimation(this, android.R.anim.fade_out)
                imageSwitcher.setImageResource(R.drawable.slide03)
            }
        )
        bt4.setOnClickListener(
            View.OnClickListener {
                imageSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
                imageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)
                imageSwitcher.setImageResource(R.drawable.slide04)
            }
        )

    }
}