package com.example.testapli

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmBroadcastReceiver : BroadcastReceiver() {

    val CLASS_NAME_TAG = "【AlarmClockApp】AlarmBroadcastReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(CLASS_NAME_TAG, "受信しました。")

        val intent = Intent(context, AlarmClockAppActivity::class.java)
            .putExtra("onReceive", true)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intent)
    }
}