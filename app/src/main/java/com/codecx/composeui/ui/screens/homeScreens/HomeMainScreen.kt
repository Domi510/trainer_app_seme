package com.codecx.composeui.ui.screens.homeScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codecx.composeui.R
import com.codecx.composeui.destinationEnum.Destination
import com.codecx.composeui.ui.components.AppImageButton
import com.codecx.composeui.ui.components.TopBar
import com.codecx.composeui.ui.theme.CardColor
import com.codecx.composeui.ui.theme.Typography
import com.codecx.composeui.utils.UserDataHolder
import com.codecx.composeui.viewModels.AuthViewModel

@Composable
fun HomeMainScreen(navController: NavController) {

    HomeMainScreenContent(navController)
}

@Composable
private fun HomeMainScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        TopBar(userName = UserDataHolder.user?.name ?: "", onCloseClick = {
            navController.navigateUp()
        })

        Text(
            text = "Ahoj, ${UserDataHolder.user?.name}.\n" +
                    "Dnes máš niekoľko tréningov !\n" +
                    "Nezabudni piť veľa vody",
            modifier = Modifier
                .padding(vertical = 15.dp)
                .fillMaxWidth()
                .background(color = CardColor, shape = RoundedCornerShape(15.dp))
                .padding(top = 10.dp, bottom = 20.dp)
                .padding(horizontal = 10.dp),
            style = Typography.labelLarge.copy(
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        )

        Column(
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .background(color = CardColor, shape = RoundedCornerShape(15.dp))
                .padding(top = 40.dp, bottom = 20.dp)
                .padding(horizontal = 15.dp), verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            AppImageButton(icon = R.drawable.ic_check, title = "Today's plan", onClick = {
                navController.navigate(Destination.Planes.name)
            })
            AppImageButton(icon = R.drawable.ic_progress, title = "My Progress", onClick = {
            })
            AppImageButton(icon = R.drawable.ic_pond, title = "Subscriptions", onClick = {
                navController.navigate(Destination.Subscription.name)
            })
            AppImageButton(icon = R.drawable.ic_notes, title = "List of clients", onClick = {
                navController.navigate(Destination.Clients.name)
            })
            AppImageButton(icon = R.drawable.dumble, title = "Workout", onClick = {})
        }


    }
}


@Composable
private fun HomeMainScreenPreview(navController: NavController) {

    HomeMainScreenContent(navController)
}