package com.example.memo

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import java.io.File

class MainActivity : AppCompatActivity(),
    FilesListFragment.OnFilesSelectListener,
    InputFragment.OnFileOutputListener {

    // ナビゲーションドロワーの状態操作用オブジェクト
    private var drawerToggle : ActionBarDrawerToggle? = null

    override fun onFileSelected(file: File) {
        val fragment = supportFragmentManager.findFragmentById(R.id.input) as InputFragment
        fragment.show(file)
    }

    override fun onFileOutput() {
        val listFragment = supportFragmentManager.findFragmentById(R.id.list) as FilesListFragment
        listFragment.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (hasPermission()) setViews()
    }

    private fun setViews() {
        setContentView(R.layout.activity_main)

        // レイアウトからドロワーを探す
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        // レイアウト中にドロワーがある場合にだけ行う処理
        if (drawerLayout != null) {
            setupDrawer(drawerLayout)
        }
    }

    private fun setupDrawer(drawer: DrawerLayout) {
        // ドロワー操作用オブジェクトを作る
        val toggle = ActionBarDrawerToggle(this, drawer, R.string.app_name, R.string.app_name)
        // ドロワーのトグルを有効にする
        toggle.isDrawerIndicatorEnabled = true
        // 開いたり閉じたりといったコールバックを設定する
        drawer.addDrawerListener(toggle)

        drawerToggle = toggle

        // アクションバーの設定を行う
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true) // ドロワー用のアイコンを表示
            setHomeButtonEnabled(true)
        }
    }

    // オプションメニューが押された時に呼ばれる
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // ドロワーに伝える
        if (drawerToggle?.onOptionsItemSelected(item) == true) {
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }

    // アクティビティの生成が終わった後に呼ばれる
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // ドロワーのトグルの状態を同期する
        drawerToggle?.syncState()
    }

    // 画面が回転したりなど、状態が変化した時に呼ばれる
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // 状態の変化をドロワーに伝える
        drawerToggle?.onConfigurationChanged(newConfig)
    }

    private fun hasPermission() : Boolean{
        // パーミッションを持っているか確認
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            // 持っていないならパーミッションを要求
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            return false
        }

        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        if (!grantResults.isEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            setViews()
            drawerToggle?.syncState()
        } else {
            finish()
        }
    }
}
