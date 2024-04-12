@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.trainer_app_prototype
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    val density = LocalDensity.current.density
    val logoSize = 150.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo v strede obrazovky
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(logoSize)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Text "Nemáš ešte účet?" nad prihlasovacími poliami
        Text(
            text = "Nemáš ešte účet?",
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = "", // Hodnota pre prihlasovacie pole
            onValueChange = {}, // Funkcia pre aktualizáciu hodnoty prihlasovacieho poľa
            label = { Text(text = "Login") }, // Popis pre prihlasovacie pole

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Heslové pole
        OutlinedTextField(
            value = "", // Hodnota pre heslové pole
            onValueChange = {}, // Funkcia pre aktualizáciu hodnoty heslového poľa
            label = { Text(text = "Heslo") }, // Popis pre heslové pole
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done), // Klávesové možnosti s akciou Done

            modifier = Modifier.fillMaxWidth()
        )

        // Menšia medzera pod prihlasovacími poliami
        Spacer(modifier = Modifier.height(8.dp))

        // Tlačidlo pre prihlásenie
        Button(
            onClick = { /* Akcia pre prihlásenie */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Prihlásiť sa")
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
