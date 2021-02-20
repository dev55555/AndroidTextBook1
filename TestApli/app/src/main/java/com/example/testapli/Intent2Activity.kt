package com.example.testapli

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        // 暗黙インテントの実装例

        bt_sms.setOnClickListener(
            View.OnClickListener {
                val number = "08031521486"
                val uri = Uri.parse("sms:$number")
                var intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                intent.putExtra("sms_body", "SMS送信サンプル")
                startActivity(intent)
            }
        )

        bt_mail.setOnClickListener(
            View.OnClickListener {
                val email: String = "toshix.ishix.info@gmail.com"
                val subject: String = "予約問い合わせ"
                val text: String = "以下の通り予約希望します。"
                val uri = Uri.parse("mailto:")
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.apply {
                    data = uri
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, text)
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        )

        bt_share.setOnClickListener(
            View.OnClickListener {
                val text: String = "美味しいレストランを紹介します。"
                val intent = Intent(Intent.ACTION_SEND)
                intent.apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, text)
                }
                val chooser = Intent.createChooser(intent, null)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(chooser)
                }
            }
        )

        bt_browse.setOnClickListener(
            View.OnClickListener {
                val url: String = "http://www.yahoo.co.jp/"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        )

    }
}