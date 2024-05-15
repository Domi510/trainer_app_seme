package com.codecx.composeui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codecx.composeui.R

// Set of Material typography styles to start with
val font = FontFamily(
    fonts = listOf(
        Font(R.font.poppins, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.poppins_medium, FontWeight.Medium, FontStyle.Normal),
        Font(R.font.poppins_semibold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.poppins_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.poppins_black, FontWeight.Black, FontStyle.Normal),
        Font(R.font.poppins_extrabold, FontWeight.ExtraBold, FontStyle.Normal)
    )
)

val Typography =   Typography(
    labelSmall = TextStyle(
        fontFamily = font,
        fontSize = 16.sp,
        color = TextColor
    ), labelLarge = TextStyle(
        fontFamily = font,
        fontSize = 24.sp,
        color = TextColor
    ), labelMedium = TextStyle(
        fontFamily = font,
        fontSize = 17.sp,
        color = TextColor
    ), headlineMedium = TextStyle(
        fontFamily = font,
        fontSize = 22.sp,
        color = TextColor, fontWeight = FontWeight.Medium
    ), headlineSmall = TextStyle(
        fontFamily = font,
        fontSize = 19.sp,
        color = TextColor, fontWeight = FontWeight.Medium
    ), headlineLarge = TextStyle(
        fontFamily = font,
        fontSize = 26.sp,
        color = TextColor, fontWeight = FontWeight.Medium
    )

)