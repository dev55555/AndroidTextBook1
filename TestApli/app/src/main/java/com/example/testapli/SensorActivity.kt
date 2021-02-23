package com.example.testapli

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SensorActivity : AppCompatActivity(), SensorEventListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)
    }

    // センサーの値が更新された時
    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            Log.d("SensorActivity",
                "x = ${event.values[0].toString()}" +
                      "y = ${event.values[0].toString()}" +
                      "z = ${event.values[0].toString()}")
        }
    }

    // センサーの精度が変わった時
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }


    // センサーの監視を開始する
    override fun onResume() {
        super.onResume()
        val sensorManager = this.getSystemService(Context.SENSOR_SERVICE)
                as SensorManager
        val accSensor = sensorManager.getDefaultSensor(
            Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_GAME)
    }

    // センサーの監視を終了する
    override fun onPause() {
        super.onPause()
        val sensorManager = this.getSystemService(Context.SENSOR_SERVICE)
                as SensorManager
        sensorManager.unregisterListener(this)
    }
}