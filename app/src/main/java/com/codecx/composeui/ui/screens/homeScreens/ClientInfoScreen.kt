package com.codecx.composeui.ui.screens.homeScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.codecx.composeui.R
import com.codecx.composeui.models.ClientModel
import com.codecx.composeui.ui.components.AppImageButton
import com.codecx.composeui.ui.components.RoundIconButton
import com.codecx.composeui.ui.components.TopBar
import com.codecx.composeui.ui.theme.CardColor
import com.codecx.composeui.ui.theme.PrimaryColor
import com.codecx.composeui.ui.theme.Typography
import com.codecx.composeui.utils.UserDataHolder
import com.codecx.composeui.viewModels.AuthViewModel
import com.google.gson.Gson

@Composable
fun ClientInfoScreen(navController: NavController) {
    val client = remember {

        derivedStateOf {
            val model = navController.currentBackStackEntry?.arguments?.getString("client")
            Gson().fromJson(model, ClientModel::class.java)
        }
    }
    ClientInfoScreenContent(

        onCloseClick = {
            navController.navigateUp()
        },
        client = client.value
    )
}

@Composable
private fun ClientInfoScreenContent(onCloseClick: () -> Unit = {}, client: ClientModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        TopBar(userName = UserDataHolder.user?.name ?: "", onCloseClick = onCloseClick)

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(bottom = 15.dp)
                .fillMaxWidth()
                .weight(1f)
                .background(color = CardColor, shape = RoundedCornerShape(15.dp))
                .padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            AppImageButton(icon = R.drawable.ic_notes, title = "List of clients", onClick = {
            })
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(vertical = 5.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                PrimaryColor,
                                RoundedCornerShape(20.dp)
                            )
                            .padding(5.dp)
                    ) {
                        ClientItem(model = client)
                        Text(
                            text = "Name: ${client.name}\nTel: ${client.number}",
                            style = Typography.labelSmall,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .weight(1f)
                                .padding(start = 10.dp)
                        )
                    }
                }
                item {
                    ClientInfoTypeHeader(title = "Ciel'")
                }
                item {
                    ClientInfoTypeHeader(title = "Zdravotneé problémy")
                }
                item {
                    ClientInfoTypeHeader(title = "Ciel'")
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 250.dp)
                            .background(color = PrimaryColor, shape = RoundedCornerShape(20.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Treningovy plan",
                                style = Typography.headlineSmall,
                                modifier = Modifier.align(Alignment.Center)
                            )
                            RoundIconButton(
                                onClick = {

                                },
                                icon = R.drawable.ic_edit,
                                modifier = Modifier.align(
                                    Alignment.CenterEnd
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ClientInfoTypeHeader(title: String, onAddClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = PrimaryColor, shape = RoundedCornerShape(40))
    ) {
        Text(
            text = title,
            style = Typography.headlineSmall,
            modifier = Modifier.align(Alignment.Center)
        )
        RoundIconButton(
            onClick = onAddClick, icon = R.drawable.ic_add, modifier = Modifier.align(
                Alignment.CenterEnd
            )
        )
    }
}


@Composable
private fun ClientInfoPreview() {

    ClientInfoScreenContent(

        onCloseClick = {}, // No operation for preview
        client = ClientModel("Miska", "+92303204230") // Sample data for client
    )
}