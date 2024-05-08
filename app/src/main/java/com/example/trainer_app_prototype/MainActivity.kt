package com.example.trainer_app_prototype
import TrainerHomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trainer_app_prototype.screens.LoginScreen
import com.example.trainer_app_prototype.screens.RegisterScreen
import com.example.trainer_app_prototype.viewModel.LoginViewModel
import com.example.trainer_app_prototype.viewModel.RegisterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: LoginViewModel by viewModels()
        val rviewModel: RegisterViewModel by viewModels()
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "loginScreen") {
        composable("loginScreen") {
            LoginScreen(navController)
        }
        composable("registerScreen") {
            RegisterScreen(navController)
        }
        composable("trainerHomeScreen") {
            TrainerHomeScreen(navController)
        }
    }
}

