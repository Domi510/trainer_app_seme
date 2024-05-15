package com.codecx.composeui.models

import androidx.compose.runtime.Stable
/**
 * Dátový model pre tréningový balík
 * */
@Stable
data class SubscriptionModel(
    val id: Int,
    val title: String,
    val price:String,

    val numberOfTrainings: Int,
    val isPaid: Boolean = false, val numberOfTrainingSeasonUsed: Int = 0
) {
    var isBasic: Boolean = false
}