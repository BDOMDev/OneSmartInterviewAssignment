package com.oshan.onesmartinterviewassignment.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController

object StatusBarUtils {

    @Suppress("DEPRECATION")
    fun setSystemUiLightStatusBar(window: Window, isLightStatusBar: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val systemUiAppearance = if (isLightStatusBar) {
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                } else {
                    0
                }
                window.insetsController?.setSystemBarsAppearance(systemUiAppearance,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
            } else {
                val systemUiVisibilityFlags = if (isLightStatusBar) {
                    window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
                window.decorView.systemUiVisibility = systemUiVisibilityFlags
            }
        }
    }

}