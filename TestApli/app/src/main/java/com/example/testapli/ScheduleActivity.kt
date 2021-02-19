package com.example.testapli

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.content_schedule.*
import org.jetbrains.anko.startActivity

class ScheduleActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        setSupportActionBar(findViewById(R.id.toolbar))

        Realm.init(this)
        realm = Realm.getDefaultInstance()

        val schedules = realm.where(Schedule::class.java).findAll()
        listView.adapter = ScheduleAdapter(schedules)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            startActivity<ScheduleEditActivity>()
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            val schedule = parent.getItemAtPosition(position) as Schedule
            startActivity<ScheduleEditActivity>(
                "schedule_id" to schedule.id )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}