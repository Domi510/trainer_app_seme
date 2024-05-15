package com.codecx.composeui.ui.screens.screens

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codecx.composeui.R
import com.codecx.composeui.destinationEnum.Destination
import com.codecx.composeui.ui.screens.homeScreens.ClientInfoScreen
import com.codecx.composeui.ui.screens.homeScreens.ClientsScreen
import com.codecx.composeui.ui.screens.homeScreens.HomeMainScreen
import com.codecx.composeui.ui.screens.homeScreens.PlansScreen
import com.codecx.composeui.ui.screens.homeScreens.SubscriptionScreen

@Composable
fun HomeScreen(navController: NavController) {
    HomeScreenContent()
}

@Composable
private fun HomeScreenContent() {
    val controller = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavHost(navController = controller, startDestination = Destination.HomeMain.name,
            enterTransition = {
                fadeIn(
                    tween(300, easing = LinearOutSlowInEasing)
                ) + slideInHorizontally(tween(300, easing = LinearOutSlowInEasing))
            }, exitTransition = {
                fadeOut(
                    tween(300, easing = LinearOutSlowInEasing)
                ) + slideOutHorizontally(tween(300, easing = LinearOutSlowInEasing))
            }, modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            composable(Destination.HomeMain.name) {
                HomeMainScreen(navController = controller)
            }
            composable(Destination.Clients.name) {
                ClientsScreen(navController = controller)
            }
            composable(Destination.Subscription.name) {
                SubscriptionScreen(navController = controller)
            }
            composable(Destination.Planes.name) {
                PlansScreen(controller)
            }
            composable(
                Destination.ClientInfo.name + "/{client}", arguments = listOf(
                    navArgument("client") {
                        NavArgument.Builder().setType(NavType.StringType).build()
                    }
                )
            ) {
                ClientInfoScreen(navController = controller)
            }
        }
        BottomButtons(onButtonClick = {
            if (it.id == 1) {
                controller.navigateUp()
            } else {
                if (it.destination == Destination.HomeMain.name) {
                    if (it.destination != controller.currentDestination?.route) {
                        controller.navigate(it.destination)
                    }
                }
            }
        })

    }
}

@Composable
private fun BottomButtons(onButtonClick: (BottomButton) -> Unit = {}) {
    val buttons = remember {
        derivedStateOf {
            listOf(
                BottomButton(1, R.drawable.ic_back, "Back"),
                BottomButton(2, R.drawable.ic_lists, Destination.Lists.name),
                BottomButton(3, R.drawable.ic_home, Destination.HomeMain.name),
                BottomButton(4, R.drawable.ic_search, Destination.Search.name),
                BottomButton(5, R.drawable.ic_care, Destination.Care.name)
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround, content = {
            buttons.value.forEach {
                Image(
                    painter = painterResource(id = it.icon),
                    contentDescription = it.destination,
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                        .clip(shape = RoundedCornerShape(20.dp))

                        .clickable {
                            onButtonClick.invoke(it)
                        }
                        .padding(7.dp)
                )
            }
        }
    )

}

@Stable
data class BottomButton(val id: Int, val icon: Int, val destination: String)

@Preview
@Composable
private fun BottomButtonPreview() {
    HomeScreenContent()
}