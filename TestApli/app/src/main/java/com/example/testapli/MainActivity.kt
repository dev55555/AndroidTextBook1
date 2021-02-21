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

        // ３章
        btButton.setOnClickListener { startActivity<ButtonActivity>() }
        btImageView.setOnClickListener { startActivity<ImageViewActivity>() }
        btHelloAndroid.setOnClickListener { startActivity<HelloAndroidAppActivity>() }

        // ６章
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

        // ７章
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
        btScrollView.setOnClickListener(
                View.OnClickListener {
                    startActivity<ScrollViewActivity>()
                }
        )
        btScrollView2.setOnClickListener(
            View.OnClickListener {
                startActivity<ScrollView2Activity>()
            }
        )
        btLinearLayout.setOnClickListener(
            View.OnClickListener {
                startActivity<LinearLayoutActivity>()
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
        btRealm.setOnClickListener(
            View.OnClickListener {
                startActivity<RealmActivity>()
            }
        )

        btScheduleApp.setOnClickListener(
                View.OnClickListener {
                    startActivity<ScheduleActivity>()
                }
        )

        btListView.setOnClickListener(
            View.OnClickListener {
                startActivity<ListViewActivity>()
            }
        )


    }
}