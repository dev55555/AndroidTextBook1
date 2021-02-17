package com.example.testapli

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.jetbrains.anko.toast

class BroadcastReceiverImpl: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.toast(context?.getString(R.string.alarm_receive))
    }
}