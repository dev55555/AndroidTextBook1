package com.example.testapli

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Realm2Model : RealmObject() {
    @PrimaryKey
    var id: Long = 0L
    var title: String = ""
}