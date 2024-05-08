package com.example.compose
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.trainer_app_prototype.ui.theme.backgroundDark
import com.example.trainer_app_prototype.ui.theme.backgroundDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.backgroundDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.backgroundLight
import com.example.trainer_app_prototype.ui.theme.backgroundLightHighContrast
import com.example.trainer_app_prototype.ui.theme.backgroundLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.customColor1ContainerDark
import com.example.trainer_app_prototype.ui.theme.customColor1ContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.customColor1ContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.customColor1ContainerLight
import com.example.trainer_app_prototype.ui.theme.customColor1ContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.customColor1ContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.customColor1Dark
import com.example.trainer_app_prototype.ui.theme.customColor1DarkHighContrast
import com.example.trainer_app_prototype.ui.theme.customColor1DarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.customColor1Light
import com.example.trainer_app_prototype.ui.theme.customColor1LightHighContrast
import com.example.trainer_app_prototype.ui.theme.customColor1LightMediumContrast
import com.example.trainer_app_prototype.ui.theme.customColor2ContainerDark
import com.example.trainer_app_prototype.ui.theme.customColor2ContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.customColor2ContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.customColor2ContainerLight
import com.example.trainer_app_prototype.ui.theme.customColor2ContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.customColor2ContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.customColor2Dark
import com.example.trainer_app_prototype.ui.theme.customColor2DarkHighContrast
import com.example.trainer_app_prototype.ui.theme.customColor2DarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.customColor2Light
import com.example.trainer_app_prototype.ui.theme.customColor2LightHighContrast
import com.example.trainer_app_prototype.ui.theme.customColor2LightMediumContrast
import com.example.trainer_app_prototype.ui.theme.errorContainerDark
import com.example.trainer_app_prototype.ui.theme.errorContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.errorContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.errorContainerLight
import com.example.trainer_app_prototype.ui.theme.errorContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.errorContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.errorDark
import com.example.trainer_app_prototype.ui.theme.errorDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.errorDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.errorLight
import com.example.trainer_app_prototype.ui.theme.errorLightHighContrast
import com.example.trainer_app_prototype.ui.theme.errorLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.inverseOnSurfaceDark
import com.example.trainer_app_prototype.ui.theme.inverseOnSurfaceDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.inverseOnSurfaceLight
import com.example.trainer_app_prototype.ui.theme.inverseOnSurfaceLightHighContrast
import com.example.trainer_app_prototype.ui.theme.inverseOnSurfaceLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.inversePrimaryDark
import com.example.trainer_app_prototype.ui.theme.inversePrimaryDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.inversePrimaryDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.inversePrimaryLight
import com.example.trainer_app_prototype.ui.theme.inversePrimaryLightHighContrast
import com.example.trainer_app_prototype.ui.theme.inversePrimaryLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.inverseSurfaceDark
import com.example.trainer_app_prototype.ui.theme.inverseSurfaceDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.inverseSurfaceDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.inverseSurfaceLight
import com.example.trainer_app_prototype.ui.theme.inverseSurfaceLightHighContrast
import com.example.trainer_app_prototype.ui.theme.inverseSurfaceLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onBackgroundDark
import com.example.trainer_app_prototype.ui.theme.onBackgroundDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onBackgroundDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onBackgroundLight
import com.example.trainer_app_prototype.ui.theme.onBackgroundLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onBackgroundLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor1ContainerDark
import com.example.trainer_app_prototype.ui.theme.onCustomColor1ContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor1ContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor1ContainerLight
import com.example.trainer_app_prototype.ui.theme.onCustomColor1ContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor1ContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor1Dark
import com.example.trainer_app_prototype.ui.theme.onCustomColor1DarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor1DarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor1Light
import com.example.trainer_app_prototype.ui.theme.onCustomColor1LightHighContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor1LightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor2ContainerDark
import com.example.trainer_app_prototype.ui.theme.onCustomColor2ContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor2ContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor2ContainerLight
import com.example.trainer_app_prototype.ui.theme.onCustomColor2ContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor2ContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor2Dark
import com.example.trainer_app_prototype.ui.theme.onCustomColor2DarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor2DarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor2Light
import com.example.trainer_app_prototype.ui.theme.onCustomColor2LightHighContrast
import com.example.trainer_app_prototype.ui.theme.onCustomColor2LightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onErrorContainerDark
import com.example.trainer_app_prototype.ui.theme.onErrorContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onErrorContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onErrorContainerLight
import com.example.trainer_app_prototype.ui.theme.onErrorContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onErrorContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onErrorDark
import com.example.trainer_app_prototype.ui.theme.onErrorDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onErrorDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onErrorLight
import com.example.trainer_app_prototype.ui.theme.onErrorLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onErrorLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onPrimaryContainerDark
import com.example.trainer_app_prototype.ui.theme.onPrimaryContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onPrimaryContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onPrimaryContainerLight
import com.example.trainer_app_prototype.ui.theme.onPrimaryContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onPrimaryDark
import com.example.trainer_app_prototype.ui.theme.onPrimaryDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onPrimaryDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onPrimaryLight
import com.example.trainer_app_prototype.ui.theme.onPrimaryLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onPrimaryLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onSecondaryContainerDark
import com.example.trainer_app_prototype.ui.theme.onSecondaryContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onSecondaryContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onSecondaryContainerLight
import com.example.trainer_app_prototype.ui.theme.onSecondaryContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onSecondaryContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onSecondaryDark
import com.example.trainer_app_prototype.ui.theme.onSecondaryDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onSecondaryDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onSecondaryLight
import com.example.trainer_app_prototype.ui.theme.onSecondaryLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onSecondaryLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onSurfaceDark
import com.example.trainer_app_prototype.ui.theme.onSurfaceDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onSurfaceDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onSurfaceLight
import com.example.trainer_app_prototype.ui.theme.onSurfaceLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onSurfaceLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onSurfaceVariantDark
import com.example.trainer_app_prototype.ui.theme.onSurfaceVariantDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onSurfaceVariantDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onSurfaceVariantLight
import com.example.trainer_app_prototype.ui.theme.onSurfaceVariantLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onTertiaryContainerDark
import com.example.trainer_app_prototype.ui.theme.onTertiaryContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onTertiaryContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onTertiaryContainerLight
import com.example.trainer_app_prototype.ui.theme.onTertiaryContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onTertiaryContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.onTertiaryDark
import com.example.trainer_app_prototype.ui.theme.onTertiaryDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.onTertiaryDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.onTertiaryLight
import com.example.trainer_app_prototype.ui.theme.onTertiaryLightHighContrast
import com.example.trainer_app_prototype.ui.theme.onTertiaryLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.outlineDark
import com.example.trainer_app_prototype.ui.theme.outlineDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.outlineDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.outlineLight
import com.example.trainer_app_prototype.ui.theme.outlineLightHighContrast
import com.example.trainer_app_prototype.ui.theme.outlineLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.outlineVariantDark
import com.example.trainer_app_prototype.ui.theme.outlineVariantDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.outlineVariantDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.outlineVariantLight
import com.example.trainer_app_prototype.ui.theme.outlineVariantLightHighContrast
import com.example.trainer_app_prototype.ui.theme.outlineVariantLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.primaryContainerDark
import com.example.trainer_app_prototype.ui.theme.primaryContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.primaryContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.primaryContainerLight
import com.example.trainer_app_prototype.ui.theme.primaryContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.primaryContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.primaryDark
import com.example.trainer_app_prototype.ui.theme.primaryDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.primaryDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.primaryLight
import com.example.trainer_app_prototype.ui.theme.primaryLightHighContrast
import com.example.trainer_app_prototype.ui.theme.primaryLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.scrimDark
import com.example.trainer_app_prototype.ui.theme.scrimDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.scrimDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.scrimLight
import com.example.trainer_app_prototype.ui.theme.scrimLightHighContrast
import com.example.trainer_app_prototype.ui.theme.scrimLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.secondaryContainerDark
import com.example.trainer_app_prototype.ui.theme.secondaryContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.secondaryContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.secondaryContainerLight
import com.example.trainer_app_prototype.ui.theme.secondaryContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.secondaryContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.secondaryDark
import com.example.trainer_app_prototype.ui.theme.secondaryDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.secondaryDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.secondaryLight
import com.example.trainer_app_prototype.ui.theme.secondaryLightHighContrast
import com.example.trainer_app_prototype.ui.theme.secondaryLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.surfaceDark
import com.example.trainer_app_prototype.ui.theme.surfaceDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.surfaceDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.surfaceLight
import com.example.trainer_app_prototype.ui.theme.surfaceLightHighContrast
import com.example.trainer_app_prototype.ui.theme.surfaceLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.surfaceVariantDark
import com.example.trainer_app_prototype.ui.theme.surfaceVariantDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.surfaceVariantDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.surfaceVariantLight
import com.example.trainer_app_prototype.ui.theme.surfaceVariantLightHighContrast
import com.example.trainer_app_prototype.ui.theme.surfaceVariantLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.tertiaryContainerDark
import com.example.trainer_app_prototype.ui.theme.tertiaryContainerDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.tertiaryContainerDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.tertiaryContainerLight
import com.example.trainer_app_prototype.ui.theme.tertiaryContainerLightHighContrast
import com.example.trainer_app_prototype.ui.theme.tertiaryContainerLightMediumContrast
import com.example.trainer_app_prototype.ui.theme.tertiaryDark
import com.example.trainer_app_prototype.ui.theme.tertiaryDarkHighContrast
import com.example.trainer_app_prototype.ui.theme.tertiaryDarkMediumContrast
import com.example.trainer_app_prototype.ui.theme.tertiaryLight
import com.example.trainer_app_prototype.ui.theme.tertiaryLightHighContrast
import com.example.trainer_app_prototype.ui.theme.tertiaryLightMediumContrast
import com.example.ui.theme.AppTypography

@Immutable
data class ExtendedColorScheme(
    val customColor1: ColorFamily,
    val customColor2: ColorFamily,
)

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
)

val extendedLight = ExtendedColorScheme(
    customColor1 = ColorFamily(
        customColor1Light,
        onCustomColor1Light,
        customColor1ContainerLight,
        onCustomColor1ContainerLight,
    ),
    customColor2 = ColorFamily(
        customColor2Light,
        onCustomColor2Light,
        customColor2ContainerLight,
        onCustomColor2ContainerLight,
    ),
)

val extendedDark = ExtendedColorScheme(
    customColor1 = ColorFamily(
        customColor1Dark,
        onCustomColor1Dark,
        customColor1ContainerDark,
        onCustomColor1ContainerDark,
    ),
    customColor2 = ColorFamily(
        customColor2Dark,
        onCustomColor2Dark,
        customColor2ContainerDark,
        onCustomColor2ContainerDark,
    ),
)

val extendedLightMediumContrast = ExtendedColorScheme(
    customColor1 = ColorFamily(
        customColor1LightMediumContrast,
        onCustomColor1LightMediumContrast,
        customColor1ContainerLightMediumContrast,
        onCustomColor1ContainerLightMediumContrast,
    ),
    customColor2 = ColorFamily(
        customColor2LightMediumContrast,
        onCustomColor2LightMediumContrast,
        customColor2ContainerLightMediumContrast,
        onCustomColor2ContainerLightMediumContrast,
    ),
)

val extendedLightHighContrast = ExtendedColorScheme(
    customColor1 = ColorFamily(
        customColor1LightHighContrast,
        onCustomColor1LightHighContrast,
        customColor1ContainerLightHighContrast,
        onCustomColor1ContainerLightHighContrast,
    ),
    customColor2 = ColorFamily(
        customColor2LightHighContrast,
        onCustomColor2LightHighContrast,
        customColor2ContainerLightHighContrast,
        onCustomColor2ContainerLightHighContrast,
    ),
)

val extendedDarkMediumContrast = ExtendedColorScheme(
    customColor1 = ColorFamily(
        customColor1DarkMediumContrast,
        onCustomColor1DarkMediumContrast,
        customColor1ContainerDarkMediumContrast,
        onCustomColor1ContainerDarkMediumContrast,
    ),
    customColor2 = ColorFamily(
        customColor2DarkMediumContrast,
        onCustomColor2DarkMediumContrast,
        customColor2ContainerDarkMediumContrast,
        onCustomColor2ContainerDarkMediumContrast,
    ),
)

val extendedDarkHighContrast = ExtendedColorScheme(
    customColor1 = ColorFamily(
        customColor1DarkHighContrast,
        onCustomColor1DarkHighContrast,
        customColor1ContainerDarkHighContrast,
        onCustomColor1ContainerDarkHighContrast,
    ),
    customColor2 = ColorFamily(
        customColor2DarkHighContrast,
        onCustomColor2DarkHighContrast,
        customColor2ContainerDarkHighContrast,
        onCustomColor2ContainerDarkHighContrast,
    ),
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

