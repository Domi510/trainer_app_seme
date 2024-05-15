package com.codecx.composeui.ui.components

import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.codecx.composeui.R
import com.codecx.composeui.ui.theme.PrimaryColor
import com.codecx.composeui.ui.theme.Typography


@Composable
fun TopBar(
    userName: String = "",
    activity: Activity? = (LocalContext.current as? Activity),

    onCloseClick: () -> Unit = {

    }
) {
    var showDialog by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Text(
            text = userName,
            modifier = Modifier
                .weight(1f)
                .background(color = PrimaryColor, shape = RoundedCornerShape(50))
                .padding(horizontal = 10.dp, vertical = 5.dp),
            style = Typography.headlineSmall.copy(
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center, fontSize = TextUnit(17f, TextUnitType.Sp)
            )
        )
        RoundIconButton(
            onClick = {
                showDialog = true

            },
            icon = R.drawable.ic_settings
        )
        RoundIconButton(onClick = {
            showDialog = true

        }, icon = R.drawable.ic_info_home)
        RoundIconButton(onClick = {
            onCloseClick()
        }, icon = R.drawable.baseline_close_24)
    }
    if (showDialog) {
        InfoDialog(onDismiss = { showDialog = false })
    }

}

@Composable
fun CloseApp() {
    val context = LocalContext.current
    val activity = context as? Activity
    activity?.finish()
}

@Composable
fun InfoDialog(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Táto funkcia je dostupná v predplatenej verzii",
                    style = Typography.bodyLarge.copy(color = Color.Black)

                )
                LaunchedEffect(key1 = true) {
                    println("InfoDialog recomposed")
                }
                Button(
                    onClick = { onDismiss() },  // This button when clicked will dismiss the dialog
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Zavrieť")
                }

            }
        }
    }
}


@Composable
fun RoundIconButton(modifier: Modifier = Modifier, onClick: () -> Unit, icon: Int) {
    IconButton(
        onClick = onClick, modifier = modifier

            .background(
                color = PrimaryColor,
                CircleShape
            )
            .size(40.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        )
    }
}

@Composable
fun AppImageButton(modifier: Modifier = Modifier, onClick: () -> Unit, title: String, icon: Int) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = PrimaryColor, shape = RoundedCornerShape(15.dp))
            .clickable {
                onClick()
            }
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = Modifier.size(60.dp)
        )
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp),
            style = Typography.labelLarge.copy(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun LoadingDialog(message: String, modifier: Modifier = Modifier) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(70.dp),
            colors = CardDefaults.cardColors(containerColor = PrimaryColor),
            shape = RoundedCornerShape(30)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    color = Color.White,
                    strokeCap = StrokeCap.Round,
                    strokeWidth = 6.dp
                )
                Text(
                    text = message,
                    style = Typography.labelMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewView() {
    LoadingDialog("Test Message")

}