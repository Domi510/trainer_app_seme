import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.trainer_app_prototype.R
import com.example.trainer_app_prototype.viewModel.TrainerHomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainerHomeScreen(navController: NavController, trainerhomeViewModel: TrainerHomeViewModel = viewModel()){
    val state = trainerhomeViewModel.state.collectAsState().value
  //  val userName = trainerhomeViewModel.  // Assuming the ViewModel holds the username
    val scrollState = rememberScrollState()
    val showDialog = remember { mutableStateOf(false) }


    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {

        SmallTopAppBar(
            title = { "Ivan Káčerík" },  // Dynamically display user name
            actions = {
                IconButton(onClick = { /* handle settings click */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_setting),
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {showDialog.value = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = "Info",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { /* handle exit click */ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_close),
                        contentDescription = "Exit",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )


    }
    if (showDialog.value) {
        InfoDialog(onDismissRequest = { showDialog.value = false })

    }
}

@Composable
fun InfoDialog(onDismissRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = { Text("O aplikácii") },
        text = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)) {
                Text("Verzia: 1.0.1", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Táto aplikácia slúži na prepojenie trénera so svojimi klientami. Ak by ste zaznamenali problém pri užívaní aplikácie, kontaktujte nás.", style = MaterialTheme.typography.bodyMedium)
                // Add more text or content as needed
            }
        },
        confirmButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text("OK")
            }
        }
    )
}


