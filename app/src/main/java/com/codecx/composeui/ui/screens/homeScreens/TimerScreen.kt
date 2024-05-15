package com.codecx.composeui.ui.screens.homeScreens
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import com.codecx.composeui.viewModels.TimerViewModel
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.codecx.composeui.R
import com.codecx.composeui.ui.components.TopBar
import com.codecx.composeui.utils.UserDataHolder

/**
 * Obrazovka pre Stopky
 * Poskytuje metódy pre navigáciu a pre ladenie stopiek
 * zo sekúnd na formát hodín a minút
 */
@Composable
fun TimerScreen(navController: NavController) {
    val timerViewModel: TimerViewModel = viewModel()
    val time by timerViewModel.time.collectAsState()
    TimerScreenContent(navController, time = time, timerViewModel = timerViewModel)
}
/**
 * Funkcia sa zaoberá nastavením obrazovky pre Stopky
 */
@Composable
private fun TimerScreenContent(navController: NavController, time:Int, timerViewModel:TimerViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        TopBar(userName = UserDataHolder.user?.name ?: "", onCloseClick = {
            navController.navigateUp()
        })
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = formatTime(time), fontSize = 32.sp, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Button(onClick = { timerViewModel.startTimer() }) {
                        Text(stringResource(R.string.start))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { timerViewModel.stopTimer() }) {
                        Text(stringResource(R.string.stop))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { timerViewModel.resetTimer() }) {
                        Text(stringResource(R.string.reset))
                    }
                }
            }
        }

    }
}


/**
 * Funkcia sa zaoberá konvertovaním času zo sekúnd na minúty a hodiny
 * @return formát v stringu čas %02d:%02d:%02d
 * @param totalSeconds - čas v sekundách
 */

fun formatTime(totalSeconds: Int): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

