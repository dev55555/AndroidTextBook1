package com.example.testapli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class
MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ３章
        btButton.setOnClickListener { startActivity<ButtonActivity>() }
        btImageView.setOnClickListener { startActivity<ImageViewActivity>() }
        btHelloAndroid.setOnClickListener { startActivity<HelloAndroidAppActivity>() }

        // ５章
        btIntent.setOnClickListener { startActivity<IntentActivity>() }
        btSharedPreference.setOnClickListener { startActivity<SharedPreferenceActivity>() }
        btJanken.setOnClickListener { startActivity<JankenActivity>() }
        btJanken2.setOnClickListener { startActivity<Janken2Activity>() }

        // ６章
        btSpinner.setOnClickListener { startActivity<SpinnerActivity>() }
        btSeekBar.setOnClickListener { startActivity<SeekBarActivity>() }
        btRadioGroup.setOnClickListener { startActivity<RadioGroupActivity>() }
        btMysizeApp.setOnClickListener { startActivity<MySizeAppActivity>() }

        // ７章
        btSensor.setOnClickListener { startActivity<SensorActivity>() }
        btSensor2.setOnClickListener { startActivity<Sensor2Activity>() }

        // ８章
        btViewPropertyAnimator.setOnClickListener { startActivity<ViewPropertyActivity>() }
        btImageSwitcher.setOnClickListener { startActivity<ImageSwitcherActivity>() }
        btTimer.setOnClickListener { startActivity<TimerActivity>() }
        btMediaPlayer.setOnClickListener { startActivity<MediaPlayerActivity>() }
        btSlideshow.setOnClickListener { startActivity<SlideshowActivity>() }

        // ９章
        btFloatingActionButton.setOnClickListener { startActivity<FloatingActionButtonActivity>() }
        btCountDown.setOnClickListener { startActivity<CountDownActivity>() }
        btSoundPool.setOnClickListener { startActivity<SoundPoolActivity>()}
        btCountDownApp.setOnClickListener { startActivity<CountDownAppActivity>() }

        // １０章
        btScrollView.setOnClickListener { startActivity<ScrollViewActivity>() }
        btScrollView2.setOnClickListener { startActivity<ScrollView2Activity>() }
        btLinearLayout.setOnClickListener { startActivity<LinearLayoutActivity>() }
        btOptionMenu.setOnClickListener { startActivity<OptionMenuActivity>() }
        btContextMenu.setOnClickListener { startActivity<ContextMenuActivity>() }
        btIntent2.setOnClickListener { startActivity<Intent2Activity>() }
        btMenuApp.setOnClickListener { startActivity<MenuAppActivity>() }

        // １１章
        btAlarmManager.setOnClickListener { startActivity<AlarmManagerActivity>() }
        btDialog.setOnClickListener { startActivity<DialogActivity>() }
        btSleepOff.setOnClickListener { startActivity<SleepOffActivity>() }
        btAlarmClockApp.setOnClickListener { startActivity<AlarmClockAppActivity>() }

        // １２章
        btListView2.setOnClickListener { startActivity<ListView2Activity>() }
        btRealm2.setOnClickListener { startActivity<Realm2Activity>() }
        btScheduleApp.setOnClickListener { startActivity<ScheduleActivity>() }

    }
}