package com.example.trainer_app_prototype.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.trainer_app_prototype.R
import com.example.trainer_app_prototype.states.RegisterState
import com.example.trainer_app_prototype.viewModel.RegisterViewModel

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel) {
    val state = registerViewModel.state.collectAsState().value
    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {

        // Adjusting the size and content arrangement of the black section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)  // Decreased weight to reduce the size
                .background(Color.Black),
            contentAlignment = Alignment.Center  // This aligns the children to the center of the Box
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val logo: Painter = painterResource(id = R.drawable.logo_stamp)
                Image(
                    painter = logo,
                    contentDescription = "Registration Logo",
                    modifier = Modifier.size(150.dp)
                )
                // Adding a spacer for space between the logo and the text
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Vytvor si účet",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.2f)
                .background(Color.White)
                .padding(horizontal = 32.dp)
        ) {

            RegistrationFormContent(registerViewModel, state)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegistrationFormContent(registerViewModel: RegisterViewModel, state: RegisterState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        createTextField(label = "Meno")

        Spacer(modifier = Modifier.height(20.dp))

        createTextField(label = "Email")

        Spacer(modifier = Modifier.height(12.dp))

        createTextField(label = "Heslo")

        Spacer(modifier = Modifier.height(12.dp))

        createTextField(label = "Tel. číslo")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = registerViewModel::register,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text("Zaregistrovať sa", color = Color.White)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun createTextField(label: String) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            textColor = Color.Black,
            disabledTextColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        visualTransformation = if (label == "Heslo") PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (label == "Email") KeyboardOptions(keyboardType = KeyboardType.Email) else KeyboardOptions.Default
    )
}

