package com.codecx.composeui.ui.screens.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codecx.composeui.R
import com.codecx.composeui.destinationEnum.Destination
import com.codecx.composeui.sealclasses.AuthStates
import com.codecx.composeui.ui.components.LoadingDialog
import com.codecx.composeui.ui.theme.BackgroundColor
import com.codecx.composeui.ui.theme.CardColorLight
import com.codecx.composeui.ui.theme.LightTextColor
import com.codecx.composeui.ui.theme.Typography
import com.codecx.composeui.viewModels.AuthViewModel
/**
 *Funkcia, ktorá prepája navigátor a obrazovku Login
 *Používa funkcie, ktoré animujú prechody
 * */
@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
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
    LoginScreenContent(onLoginClick = { email, password ->
        viewModel.requestForLogin(email, password)
    }, onSignUpClick = {
        navController.navigate(Destination.SignUp.name)
    })
}
/**
 *Funkcia pre rozloženie Login obrazovky
 * */
@Composable
private fun LoginScreenContent(

    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onSignUpClick: () -> Unit = {}
) {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(0.2f))
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(color = Color.White, shape = RoundedCornerShape(15.dp))
        )
        Spacer(modifier = Modifier.weight(0.13f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
                .padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.login),
                modifier = Modifier.padding(top = 40.dp),
                style = Typography.headlineLarge.copy(
                    Color.Black, fontWeight = FontWeight.SemiBold, fontSize = TextUnit(
                        35f,
                        TextUnitType.Sp
                    )
                )
            )
            Text(
                text = stringResource(R.string.prihl_s_sa_a_pokra_uj),
                modifier = Modifier.padding(top = 3.dp),
                style = Typography.labelSmall.copy(
                    LightTextColor
                )
            )
            Text(
                text = "EMAIL",
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.Start),
                style = Typography.labelMedium.copy(
                    LightTextColor
                )
            )
            Inputs(value = email, hint = stringResource(R.string.hello_gmail_com))
            Text(
                text = stringResource(R.string.heslo),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.Start),
                style = Typography.labelMedium.copy(
                    LightTextColor
                )
            )
            PasswordInputs(value = password, hint = stringResource(R.string.password))
            Button(
                onClick = { onLoginClick(email.value, password.value) },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(20)
            ) {
                Text(
                    text = stringResource(R.string.prihl_si_sa),
                    style = Typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold, fontSize = TextUnit(
                            20f,
                            TextUnitType.Sp
                        )
                    ),
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.e_te_nem_et) +
                        stringResource(R.string.tak_klikni_sem_a_zaregistruj_sa),
                modifier = Modifier
                    .clickable {
                        onSignUpClick()
                    }
                    .padding(vertical = 15.dp),
                style = Typography.labelSmall.copy(
                    LightTextColor, textAlign = TextAlign.Center
                )
            )

        }
    }
}
/**
 *Funkcia pre jednotlivý textField - nie je špeciálny
 * */
@Composable
fun Inputs(
    value: MutableState<String>,
    hint: String,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        decorationBox = { innerTextField ->
            if (value.value.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = hint,
                        modifier = Modifier
                            .align(Alignment.CenterStart),
                        textAlign = TextAlign.Start,
                        style = Typography.labelMedium.copy(LightTextColor)
                    )
                }
            } else {
                Box(contentAlignment = Alignment.CenterStart) {
                    innerTextField()
                }
            }
        },
        modifier = modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .height(54.dp)
            .background(color = CardColorLight, shape = RoundedCornerShape(40))
            .padding(horizontal = 15.dp),
        textStyle = Typography.labelMedium.copy(Color.Black)
    )
}
/**
 *Funkcia pre textFiled- tel. číslo
 * po rozbalení klávesnice - čísla
 * */
@Composable
fun InputTelephone(
    value: MutableState<String>,
    hint: String,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        decorationBox = { innerTextField ->
            if (value.value.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = hint,
                        modifier = Modifier
                            .align(Alignment.CenterStart),
                        textAlign = TextAlign.Start,
                        style = Typography.labelMedium.copy(LightTextColor)
                    )
                }
            } else {
                Box(contentAlignment = Alignment.CenterStart) {
                    innerTextField()
                }
            }
        },
        modifier = modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .height(54.dp)
            .background(color = CardColorLight, shape = RoundedCornerShape(40))
            .padding(horizontal = 15.dp),
        textStyle = Typography.labelMedium.copy(Color.Black),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
            capitalization = KeyboardCapitalization.None
        )
    )
}
/**
 *Funkcia, ktorá zabezpečuje textField pre vloženie hesla
 * */
@Composable
fun PasswordInputs(
    value: MutableState<String>,
    hint: String,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        decorationBox = { innerTextField ->
            if (value.value.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = hint,
                        modifier = Modifier
                            .align(Alignment.CenterStart),
                        textAlign = TextAlign.Start,
                        style = Typography.labelMedium.copy(LightTextColor)
                    )
                }
            } else {
                Box(contentAlignment = Alignment.CenterStart) {
                    innerTextField()
                }
            }
        },
        modifier = modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .height(54.dp)
            .background(color = CardColorLight, shape = RoundedCornerShape(40))
            .padding(horizontal = 15.dp),
        textStyle = Typography.labelMedium.copy(Color.Black),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            capitalization = KeyboardCapitalization.None
        )
    )
}

@Composable
@Preview
private fun LoginScreenPreview() {
    LoginScreenContent()
}