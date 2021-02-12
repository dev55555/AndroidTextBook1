package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        btSpinner.setOnClickListener(
            View.OnClickListener {
                startActivity<SpinnerActivity>()
            }
        )

        btSeekBar.setOnClickListener(
            View.OnClickListener {
                startActivity<SeekBarActivity>()
            }
        )

        btRadioGroup.setOnClickListener(
            View.OnClickListener {
                startActivity<RadioGroupActivity>()
            }
        )

        btFloatingActionButton.setOnClickListener(
            View.OnClickListener {
                startActivity<FloatingActionButtonActivity>()
            }
        )

        btSensor.setOnClickListener(
            View.OnClickListener {
                startActivity<SensorActivity>()
            }
        )

        btSensor2.setOnClickListener(
            View.OnClickListener {
                startActivity<Sensor2Activity>()
            }
        )

        btSlideshow.setOnClickListener(
            View.OnClickListener {
                startActivity<SlideshowActivity>()
            }
        )

        btSlideshow3.setOnClickListener(
            View.OnClickListener {
                startActivity<Slideshow3Activity>()
            }
        )

        btCountDown.setOnClickListener(
            View.OnClickListener {
                startActivity<CountDownActivity>()
            }
        )

        btOptionMenu.setOnClickListener(
            View.OnClickListener {
                startActivity<OptionMenuActivity>()
            }
        )

        btContextMenu.setOnClickListener(
            View.OnClickListener {
                startActivity<ContextMenuActivity>()
            }
        )

        btIntent2.setOnClickListener(
            View.OnClickListener {
                startActivity<Intent2Activity>() }
        )

        btImageSwitcher.setOnClickListener(
            View.OnClickListener {
                startActivity<ImageSwitcherActivity>()
            }
        )

        btTimer.setOnClickListener(
            View.OnClickListener {
                startActivity<TimerActivity>()
            }
        )


    }
}