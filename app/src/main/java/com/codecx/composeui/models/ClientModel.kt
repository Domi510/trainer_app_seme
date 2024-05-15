package com.codecx.composeui.models

import androidx.compose.runtime.Stable
import com.codecx.composeui.R
import java.io.Serializable


@Stable
data class ClientModel(val name: String, val number: String) : Serializable {
    val image = R.drawable.img_user
}