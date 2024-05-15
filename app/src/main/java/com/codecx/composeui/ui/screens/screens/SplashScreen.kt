package com.codecx.composeui.ui.screens.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codecx.composeui.destinationEnum.Destination
import com.codecx.composeui.sealclasses.AuthStates
import com.codecx.composeui.ui.components.LoadingDialog
import com.codecx.composeui.ui.theme.BackgroundColor
import com.codecx.composeui.ui.theme.CardColor
import com.codecx.composeui.ui.theme.PrimaryColor
import com.codecx.composeui.ui.theme.Typography
import com.codecx.composeui.viewModels.AuthViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
    val authState = viewModel.authState.collectAsState()
    val isLoading = remember(key1 = authState.value) {
        derivedStateOf {
            authState.value is AuthStates.Loading
        }
    }
    LaunchedEffect(key1 = true) {
        delay(500L)
        viewModel.loadAccountInfo()
    }
    if (isLoading.value) {
        LoadingDialog(message = (authState.value as AuthStates.Loading).message)
    }
    SplashScreenContent { buttonId ->
        if (viewModel.auth.currentUser == null) {
            navController.navigate(Destination.Login.name)
        } else {
            navController.navigate(Destination.Home.name) {
                popUpTo(Destination.Splash.name) {
                    inclusive = true
                }
            }
        }
    }
}


@Composable
private fun SplashScreenContent(onButtonClick: (Int) -> Unit = {}) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(color = Color.White, shape = RoundedCornerShape(15.dp))
        )
        Spacer(modifier = Modifier.weight(1f))
        Card(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(containerColor = CardColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 80.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                TextButton(
                    onClick = {
                        onButtonClick.invoke(1)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                    modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = "Som klient",
                        style = Typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
                TextButton(
                    onClick = {
                        onButtonClick.invoke(2)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                    modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = "Som tréner",
                        style = Typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(3f))

    }
}

@Composable
@Preview
private fun SplashScreenPreview() {
    SplashScreenContent()
}