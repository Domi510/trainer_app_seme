package com.example.trainer_app_prototype.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.trainer_app_prototype.R
import com.example.trainer_app_prototype.ui.theme.DarkBlue // Import your custom color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val uiState = viewModel.uiState.observeAsState().value ?: LoginUIState()
    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {

        // Top section with black background
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Black)) {
            // Placeholder for logo
            val logo: Painter = painterResource(R.drawable.logo_stamp) // Replace with painterResource(R.drawable.logo)
            Image(
                painter = logo,
                contentDescription = "Login Logo",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.Center)
            )
        }

        // Bottom section with white background
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)
            .background(Color.White)
            .padding(horizontal = 32.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                // Title "Login"
                Text("Login", style = MaterialTheme.typography.headlineMedium)

                // Subtitle "Prihlás sa a pokračuj"
                Text("Prihlás sa a pokračuj", style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = uiState.username,
                    onValueChange = viewModel::updateUsername,
                    label = { Text("Meno") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = uiState.password,
                    onValueChange = viewModel::updatePassword,
                    label = { Text("Heslo") },
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = viewModel::login,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue)
                ) {
                    Text("Prihlásiť sa")
                }
                Spacer(modifier = Modifier.height(24.dp))

                // Static text
                Text("Ešte nemáš účet?")

                // Clickable text
                Text(
                    text = "Tak klikni sem a zaregistruj sa!",
                    modifier = Modifier.clickable { /* Handle click here */ },
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline)
                )
            }
        }
    }
}