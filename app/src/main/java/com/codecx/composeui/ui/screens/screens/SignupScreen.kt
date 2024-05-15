package com.codecx.composeui.ui.screens.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codecx.composeui.R
import com.codecx.composeui.destinationEnum.Destination
import com.codecx.composeui.models.User
import com.codecx.composeui.sealclasses.AuthStates
import com.codecx.composeui.ui.components.LoadingDialog
import com.codecx.composeui.ui.theme.BackgroundColor
import com.codecx.composeui.ui.theme.LightTextColor
import com.codecx.composeui.ui.theme.Typography
import com.codecx.composeui.viewModels.AuthViewModel

@Composable
fun SignUpScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val authState = viewModel.authState.collectAsState()
    val isLoading = remember(key1 = authState.value) {
        derivedStateOf {
            authState.value is AuthStates.Loading
        }
    }
    if (isLoading.value) {
        LoadingDialog(message = (authState.value as AuthStates.Loading).message)
    }
    LaunchedEffect(key1 = authState.value) {
        if (authState.value is AuthStates.Success) {
            navController.navigate(Destination.Home.name) {
                popUpTo(Destination.Splash.name) {
                    inclusive = true
                }
            }
        } else if (authState.value is AuthStates.Fail) {
            Toast.makeText(
                context,
                (authState.value as AuthStates.Fail).message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    SignUpScreenContent(onSignUpClick = { user ->
        viewModel.requestForSignUp(user)
    }, onBackClick = {
        navController.navigateUp()
    })
}

@Composable
private fun SignUpScreenContent(
    onSignUpClick: (User) -> Unit = { },
    onBackClick: () -> Unit = {}
) {
    val userName = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val phoneNumber = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.04f))
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                contentDescription = "Back Icon", modifier = Modifier.size(35.dp)
            )
        }
        Spacer(modifier = Modifier.weight(0.04f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .background(Color.White)
                .padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Vytvor si úcet",
                modifier = Modifier.padding(top = 40.dp),
                style = Typography.headlineLarge.copy(
                    Color.Black, fontWeight = FontWeight.SemiBold, fontSize = TextUnit(
                        35f,
                        TextUnitType.Sp
                    )
                )
            )
            Text(
                text = "Uz si zaregistrovaný ? Klikni sem",
                modifier = Modifier.padding(top = 3.dp),
                style = Typography.labelSmall.copy(
                    LightTextColor, fontSize = TextUnit(12f, TextUnitType.Sp)
                )
            )
            Text(
                text = "MENO",
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.Start),
                style = Typography.labelMedium.copy(
                    LightTextColor
                )
            )
            Inputs(value = userName, hint = "Jiara Martins")
            Text(
                text = "EMAIL",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.Start),
                style = Typography.labelMedium.copy(
                    LightTextColor
                )
            )

            Inputs(value = email, hint = "hello@reallygreatsite.com")
            Text(
                text = "HESLO",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.Start),
                style = Typography.labelMedium.copy(
                    LightTextColor
                )
            )

            PasswordInputs(value = password, hint = "******")
            Text(
                text = "TEL. CÍSLO",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.Start),
                style = Typography.labelMedium.copy(
                    LightTextColor
                )
            )

            InputTelephone(value = phoneNumber, hint = "Phone No")
            Button(
                onClick = {
                    onSignUpClick(
                        User(
                            userName.value,
                            email.value,
                            phoneNumber.value
                        ).also {
                            it.password = password.value
                        }
                    )
                },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(20)
            ) {
                Text(
                    text = "Zaregistrovat sa",
                    style = Typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold, fontSize = TextUnit(
                            20f,
                            TextUnitType.Sp
                        )
                    ),
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }


        }
    }
}


@Composable
@Preview
private fun SignUpScreenPreview() {
    SignUpScreenContent()
}