package com.codecx.composeui.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

object TimeUtils {

    fun getTimeZoneInfo(): String {
        val timeZone = TimeZone.getDefault()
        val offset = timeZone.rawOffset / (1000 * 60 * 60)
        val offsetString =
            String.format("%+03d:%02d", offset, timeZone.rawOffset % (1000 * 60 * 60) / (1000 * 60))
        val timeZoneID = timeZone.id
        return "GMT$offsetString $timeZoneID"
    }

    fun getTimeFormat(time: Long?): String {
        return if (time != null) {
            SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(time)
        } else {
            "Time not found"
        }
    }

    fun getDateFormat(time: Long?, pattern: String = "EEE MMM dd, yyyy"): String {
        return if (time != null) {
            SimpleDateFormat(pattern, Locale.US).format(time)
        } else {
            "Time not found"
        }
    }

    fun getDateTimeFormat(time: Long?, pattern: String = "EEE MMM dd, yyyy hh:mm:ss a"): String {
        return if (time != null) {
            SimpleDateFormat(pattern, Locale.US).format(time)
        } else {
            "Time not found"
        }

    }

    fun formatDuration(durationInMillis: Long?): String {
        return if (durationInMillis != null) {
            val seconds = (durationInMillis / 1000).toInt()
            val hours = seconds / 3600
            val minutes = seconds % 3600 / 60
            val remainingSeconds = seconds % 60
            if (hours != 0) {

                String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
            } else {
                String.format("%02d:%02d", minutes, remainingSeconds)
            }
        } else {
            "0:0"
        }

    }


}