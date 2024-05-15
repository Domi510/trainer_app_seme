package com.codecx.composeui.ui.screens.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codecx.composeui.R
import com.codecx.composeui.destinationEnum.Destination
import com.codecx.composeui.models.ClientModel
import com.codecx.composeui.ui.components.AppImageButton
import com.codecx.composeui.ui.components.TopBar
import com.codecx.composeui.ui.theme.CardColor
import com.codecx.composeui.ui.theme.Typography
import com.codecx.composeui.utils.UserDataHolder
import com.codecx.composeui.viewModels.AuthViewModel
import com.google.gson.Gson
/**
 *Funkcia pracujúca s navigáciou - prepojené so zoznamom klientov
 * */
@Composable
fun ClientsScreen(navController: NavController) {
    ClientsScreenContent(navController)
}
/**
 *Funkcia, ktorá vykresľuje celkovú obrazovku Zoznamu klientov
 * */
@Composable
private fun ClientsScreenContent(navController: NavController) {
    val clients = remember {
        derivedStateOf {
            listOf(
                ClientModel("Miska", "+92303204230"),
                ClientModel("Juraj", "+92303204230"),
                ClientModel("Robert", "+92303204230"),
                ClientModel("Janka", "+92303204230"),
                ClientModel("Daniel", "+92303204230"),
                ClientModel("Veronika", "+92303204230"),
                ClientModel("Miska", "+92303204230"),
                ClientModel("Juraj", "+92303204230"),
                ClientModel("Robert", "+92303204230"),
                ClientModel("Janka", "+92303204230"),
                ClientModel("Daniel", "+92303204230"),
                ClientModel("Veronika", "+92303204230")
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        TopBar(userName = UserDataHolder.user?.name ?: "", onCloseClick = {
            navController.navigateUp()
        })


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
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(vertical = 15.dp),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                items(clients.value) {
                    ClientItem(
                        model = it,
                        modifier = Modifier.width(100.dp),
                        onClick = { clickClient ->
                            navController.navigate(
                                Destination.ClientInfo.name + "/${
                                    Gson().toJson(
                                        clickClient
                                    )
                                }"
                            )
                        })
                }
            }
        }
    }
}
/**
 * Funkcia, ktorá nastavuje jednotlivé polia v kartách
 * */
@Composable
fun ClientItem(
    model: ClientModel,
    modifier: Modifier = Modifier,
    onClick: (ClientModel) -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(130.dp)
            .height(160.dp)
            .background(Color.White, RoundedCornerShape(25.dp))
            .clickable { onClick(model) }
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Text(
            text = model.name,
            style = Typography.labelLarge.copy(Color.Black, fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}

/**
 * Funkcia sprístupňujúca Preview model
 * */
@Preview
@Composable
private fun ClientsPreview() {

    ClientsScreenContent(rememberNavController())
}