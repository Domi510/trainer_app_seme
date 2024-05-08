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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.trainer_app_prototype.R
import com.example.trainer_app_prototype.states.RegisterState
import com.example.trainer_app_prototype.viewModel.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController,
                   registerViewModel: RegisterViewModel = viewModel()) {
    val state = registerViewModel.state.collectAsState().value
    val scrollState = rememberScrollState()
    val showDialog = registerViewModel.showDialog.value

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {
        TopAppBar(
            title = { Text("Mám účet", color = Color.White) }, // Set text color to white
            navigationIcon = {
                IconButton(onClick = { navController.navigate("loginScreen") }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White // Set icon color to white
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Black // Set background color to black
            )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)  // Decreased weight to reduce the size
                .background(MaterialTheme.colorScheme.background),
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

    if (showDialog) {
        RoleSelectionDialog(showDialog = registerViewModel.showDialog, onRoleSelected = registerViewModel::handleRoleSelection)
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
        
        createTextFieldR(label = "Meno")

        Spacer(modifier = Modifier.height(20.dp))

        createTextFieldR(label = "Email")

        Spacer(modifier = Modifier.height(12.dp))

        createTextFieldR(label = "Heslo")

        Spacer(modifier = Modifier.height(12.dp))

        createTextFieldR(label = "Tel. číslo")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = registerViewModel::register,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Zaregistrovať sa", color = Color.White)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun createTextFieldR(label: String) {
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
        keyboardOptions = if (label == "Email") KeyboardOptions(keyboardType = KeyboardType.Email) else KeyboardOptions.Default,

    )
}
@Composable
fun RoleSelectionDialog(showDialog: MutableState<Boolean>, onRoleSelected: (String) -> Unit) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Vyber si svoju rolu") },
            text = { Text("Si klient alebo tréner?") },
            confirmButton = {
                TextButton(onClick = { onRoleSelected("Client") }) {
                    Text("Klient")
                }
            },
            dismissButton = {
                TextButton(onClick = { onRoleSelected("Trainer") }) {
                    Text("Tréner")
                }
            }
        )
    }
}



