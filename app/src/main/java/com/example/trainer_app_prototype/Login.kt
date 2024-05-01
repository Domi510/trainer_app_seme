import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app_prototype.ui.theme.*

@Preview
@ExperimentalMaterial3Api
@Composable
fun RegisterScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Black)) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .background(Color.White)
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Vytvor si účet",

                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Start)
            )
            TextButton(
                onClick = { /* Navigate to login */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
            ) {
                Text("Už si zaregistrovaný? Klikni sem", color = Purple80, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            var name = TextFieldValue()
            var email = TextFieldValue()
            var password = TextFieldValue()
            var phone = TextFieldValue()

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Meno") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Heslo") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Tel. číslo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Text("Zaregistrovať sa", fontSize = 16.sp)
            }
        }
    }
}