package com.codecx.composeui.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.codecx.composeui.ui.theme.Orange
import com.codecx.composeui.ui.theme.StrokeColor
import java.util.Calendar
/**
 * Dátový model pre plánovací model
 * @param from
 * @param to
 * @param name
 * @param score
 * */
data class PlanModel(val from: Long, val to: Long, val name: String, val score: Int) {
    val InfoColor @Composable get() = if (score in 3..5) Orange else if (score <= 2) Color.Red else Color.White

    companion object {
        fun getTimeInMillis(hourOfDay: Int, minute: Int): Long {
            val calendar = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, hourOfDay)
                set(Calendar.MINUTE, minute)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }
            return calendar.timeInMillis
        }
    }
}