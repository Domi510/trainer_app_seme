@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.trainer_app_prototype

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app_prototype.ui.theme.Black
import kotlin.math.round

@Preview
@Composable
fun LoginPage(){
    Surface(modifier = Modifier.fillMaxSize(), color=Color(R.color.pozadie)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_stamp),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Priihlás sa pre pokračovanie",
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(bottom = 8.dp)
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

                modifier = Modifier.fillMaxWidth().background(Color(R.color.pozadie)),

            ) {
                Text(text = "Prihlásiť sa")
            }
        }










    }

}

@Composable
fun hornaCast(){



}