package com.oshan.onesmartinterviewassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oshan.onesmartinterviewassignment.utils.StatusBarUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBarUtils.setSystemUiLightStatusBar(this.window, true)


    }
}