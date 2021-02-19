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

        // ８章
        btViewPropertyAnimator.setOnClickListener(
                View.OnClickListener {
                    startActivity<ViewPropertyActivity>()
                }
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
        btMediaPlayer.setOnClickListener(
                View.OnClickListener {
                    startActivity<MediaPlayerActivity>()
                }
        )
        btSlideshow.setOnClickListener(
                View.OnClickListener {
                    startActivity<SlideshowActivity>()
                }
        )
        // ９章
        btFloatingActionButton.setOnClickListener(
            View.OnClickListener {
                startActivity<FloatingActionButtonActivity>()
            }
        )
        btCountDown.setOnClickListener(
            View.OnClickListener {
                startActivity<CountDownActivity>()
            }
        )
        btSoundPool.setOnClickListener(
            View.OnClickListener {
                startActivity<SoundPoolActivity>()
            }
        )

        btCountDownApp.setOnClickListener(
            View.OnClickListener {
                startActivity<CountDownAppActivity>()
            }
        )

        // １０章
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

        btMenuApp.setOnClickListener(
            View.OnClickListener {
                startActivity<MenuAppActivity>() }
        )

        // １１章
        btAlarmManager.setOnClickListener(
            View.OnClickListener {
                startActivity<AlarmManagerActivity>()
            }
        )

        btDialog.setOnClickListener(
            View.OnClickListener {
                startActivity<DialogActivity>()
            }
        )

        btSleepOff.setOnClickListener(
            View.OnClickListener {
                startActivity<SleepOffActivity>()
            }
        )

        btAlarmClockApp.setOnClickListener(
            View.OnClickListener {
                startActivity<AlarmClockAppActivity>()
            }
        )

        // １２章
        btScheduleApp.setOnClickListener(
                View.OnClickListener {
                    startActivity<ScheduleActivity>()
                }
        )

        //以下はまだ未整理
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








    }
}