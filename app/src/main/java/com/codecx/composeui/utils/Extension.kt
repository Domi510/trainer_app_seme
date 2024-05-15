package com.codecx.composeui.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged

import java.io.IOException


infix fun String.valueWithBoldHeading(value: String): SpannableStringBuilder {
    val stringBuilder = SpannableStringBuilder()
    val boldStyle = StyleSpan(Typeface.BOLD)
    stringBuilder.append(this)
    stringBuilder.setSpan(
        boldStyle,
        stringBuilder.length - this.length,
        stringBuilder.length,
        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
    )
    stringBuilder.append(" $value")
    return stringBuilder
}


fun <T : Any> Activity.startNewActivity(
    mClass: Class<T>,
    finish: Boolean = false,
    values: (Intent) -> Unit = {}
) {
    startActivity(Intent(this, mClass).also {
        values(it)
    })
    if (finish) {
        finish()
    }
}


fun dpToPx(context: Context, dp: Int): Int {
    return (dp * context.resources.displayMetrics.density).toInt()
}

fun Context.assetsToBitmap(fileName: String): Bitmap? {
    return try {
        with(assets.open(fileName)) {
            BitmapFactory.decodeStream(this)
        }
    } catch (e: IOException) {
        null
    }
}

fun Context.showToast(message: String?) {
    message?.let {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}

fun String.showLog(message: String) {
    Log.d(this, message)
}

fun View.beGone() {
    if (this.isVisible || this.isInvisible) {
        this.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out))
        this.visibility = View.GONE
    }
}

fun View.beVisible() {
    if (this.isGone || this.isInvisible) {
        this.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in))
        this.visibility = View.VISIBLE
    }
}

fun View.beInVisible() {
    if (this.isGone || this.isVisible) {
        this.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out))
        this.visibility = View.INVISIBLE
    }
}


fun Activity.enableFullScreenMode() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val controller = window.insetsController
        controller?.systemBarsBehavior =
            WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        controller?.hide(WindowInsets.Type.statusBars())
    } else {
        window.decorView.systemUiVisibility =
            window.decorView.systemUiVisibility or
                    WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE or
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}

fun Context.getTintList(color: Int): ColorStateList {
    return ColorStateList.valueOf(getMyResColor(color))
}

fun Context.getMyResColor(color: Int): Int {
    return ContextCompat.getColor(this, color)
}

fun Activity.fullMode() {
    window.decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    val window: Window = window
    window.statusBarColor = Color.TRANSPARENT
//    val contentView = findViewById<View>(android.R.id.content)
//    contentView.setPadding(0, getStatusBarHeight(), 0, 0)
    setStatusBarLightMode(true)
}

private fun Activity.getStatusBarHeight(): Int {
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else {
        0
    }
}

fun Activity.setStatusBarLightMode(isLightMode: Boolean) {
    var systemUiVisibilityFlags = window.decorView.systemUiVisibility

    if (isLightMode) {
        systemUiVisibilityFlags =
            systemUiVisibilityFlags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else {
        systemUiVisibilityFlags =
            systemUiVisibilityFlags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
    }
    window.decorView.systemUiVisibility = systemUiVisibilityFlags
}

@SuppressLint("ClickableViewAccessibility")
fun View.onClickListener(listener: (View) -> Unit) {
    val zoomIn = ScaleAnimation(
        1f,
        0.8f,
        1f,
        0.8f,
        Animation.RELATIVE_TO_SELF,
        0.5f,
        Animation.RELATIVE_TO_SELF,
        0.5f
    ).apply {
        duration = 200
        fillAfter = true
    }

    val zoomOut = ScaleAnimation(
        0.8f,
        1f,
        0.8f,
        1f,
        Animation.RELATIVE_TO_SELF,
        0.5f,
        Animation.RELATIVE_TO_SELF,
        0.5f
    ).apply {
        duration = 200
        fillAfter = true
    }

    setOnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                view.startAnimation(zoomIn)
                true
            }

            MotionEvent.ACTION_UP -> {
                view.startAnimation(zoomOut)
                listener.invoke(view)
                false
            }

            MotionEvent.ACTION_CANCEL -> {
                view.startAnimation(zoomOut)
                false
            }

            else -> false
        }
    }
}


fun Activity.exitFullMode() {
    window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
}

fun Activity.changeStatusBarColor(id: Int) {
    window.statusBarColor = getMyResColor(id)
}

fun Context.getMyResDrawable(id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

fun Int.toDp(): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()
}


