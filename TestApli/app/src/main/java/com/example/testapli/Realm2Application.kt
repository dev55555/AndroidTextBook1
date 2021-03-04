package com.example.testapli

import android.app.Application
import io.realm.Realm

class Realm2Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}