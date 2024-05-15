package com.codecx.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codecx.composeui.destinationEnum.Destination
import com.codecx.composeui.ui.theme.ComposeUiTheme
import com.codecx.composeui.ui.screens.screens.HomeScreen
import com.codecx.composeui.ui.screens.screens.LoginScreen
import com.codecx.composeui.ui.screens.screens.SignUpScreen
import com.codecx.composeui.ui.screens.screens.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        setContent {
            ComposeUiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavScreen()
                }
            }
        }
    }

    @Composable
    private fun NavScreen() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Destination.Splash.name,
            enterTransition = {
                fadeIn(
                    tween(500, easing = LinearOutSlowInEasing)
                ) + slideInHorizontally(tween(500, easing = LinearOutSlowInEasing))
            }, exitTransition = {
                fadeOut(
                    tween(500, easing = LinearOutSlowInEasing)
                ) + slideOutHorizontally(tween(500, easing = LinearOutSlowInEasing))
            }
        ) {
            composable(Destination.Splash.name) {
                SplashScreen(navController = navController)
            }
            composable(Destination.Login.name) {
                LoginScreen(navController = navController)
            }
            composable(Destination.SignUp.name) {
                SignUpScreen(navController = navController)
            }
            composable(Destination.Home.name) {
                HomeScreen(navController = navController)
            }

        }
    }
}
