package com.example.testapli

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SleepOffBroadcastReceiver : BroadcastReceiver() {
    val ACTIVITY_NAME = "SleepOffActivity"
    val CLASS_NAME_TAG = "SleepOffBroadcastReceiver"
    val LOG_MESSAGE = ACTIVITY_NAME + "：ブロードキャストメッセージを受信しました"
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(CLASS_NAME_TAG, LOG_MESSAGE)

        val intent = Intent(context, SleepOffActivity::class.java)
                .putExtra("onReceive", true)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intent)
    }
}