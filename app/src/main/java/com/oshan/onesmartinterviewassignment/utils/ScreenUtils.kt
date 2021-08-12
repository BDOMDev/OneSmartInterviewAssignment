package com.oshan.onesmartinterviewassignment.utils


/*
 * Copyright (C) 2019 Oshan Madushanka
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.TypedValue



object ScreenUtils {

    /**
     * Returns the width of the screen
     *
     * @return int screen width (pixels)
     */
    val screenWidth: Int
        get() = Resources.getSystem().displayMetrics.widthPixels

    /**
     * Returns the height of the screen
     *
     * @return int screen height (pixels)
     */
    val screenHeight: Int
        get() = Resources.getSystem().displayMetrics.heightPixels

    /**
     * Returns the dp(Density-independent Pixels) value of the given px(Pixels) value
     *
     * @param px px value
     *
     * @return int converted value (dp)
     */
    fun pxToDp(px: Float): Int {
        return Math.round(px / Resources.getSystem().displayMetrics.density)
    }

    /**
     * Returns the px(Pixels) value of the given dp(Density-independent Pixels) value
     *
     * @param dp dp value
     *
     * @return int converted value (px)
     */
    fun dpToPx(dp: Float): Int {
        return Math.round(dp * Resources.getSystem().displayMetrics.density)
    }

    /**
     * Returns the DP(Density-independent Pixels) value of the given SP(Scale-independent Pixels) value
     *
     * @param sp sp value
     *
     * @return int converted value (px)
     */
    fun spToPx(sp: Float): Int {
        return Math.round(
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                sp, Resources.getSystem().displayMetrics
            )
        )
    }

    /**
     * Returns the SP(Scale-independent Pixels) value of the given Pixels value
     *
     * @param px px value
     *
     * @return int converted value (sp)
     */
    fun pxToSp(px: Float): Int {
        return Math.round(px / Resources.getSystem().displayMetrics.density)
    }

    /**
     * Returns the DP(Density-independent Pixels) value of the given SP(Scale-independent Pixels) value
     *
     * @param dp dp value
     *
     * @return int converted value (sp)
     */
    fun dpToSp(dp: Float): Int {
        return Math.round(dpToPx(dp) /  spToPx(dp).toFloat())
    }


    /**
     * Returns the height of the StatusBar
     *
     * @param context context
     *
     * @return int
     */
    fun getStatusBarHeight(context: Context): Int {
        val resources = context.resources
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (resourceId > 0)
            resources.getDimensionPixelSize(resourceId)
        else
            Math.ceil(((if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) 24 else 25) * resources.displayMetrics.density).toDouble()).toInt()
    }



}
