package com.codecx.composeui.ui.screens.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codecx.composeui.R
import com.codecx.composeui.models.SubscriptionModel
import com.codecx.composeui.ui.components.AppImageButton
import com.codecx.composeui.ui.components.TopBar
import com.codecx.composeui.ui.theme.PrimaryColor
import com.codecx.composeui.ui.theme.Typography
import com.codecx.composeui.utils.UserDataHolder

@Composable
fun SubscriptionScreen(navController: NavController) {
    SubscriptionScreenContent(navController)
}

@Composable
private fun SubscriptionScreenContent(navController: NavController) {
    val subs = remember {
        derivedStateOf {
            listOf(
                SubscriptionModel(1, "Basic package", "200 €", 10).also {
                    it.isBasic = true
                }, SubscriptionModel(2, "Premium package", "400 €", 15),
                SubscriptionModel(3, "SM package", "150 €", 10),
                SubscriptionModel(4, "Training plan", "50 €", 1)
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        TopBar(userName = UserDataHolder.user?.name ?: "",onCloseClick = {
            navController.navigateUp()
        })


        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(bottom = 15.dp)
                .fillMaxWidth()
                .weight(1f)
                .padding(15.dp), verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            AppImageButton(icon = R.drawable.ic_pond, title = "Subscription", onClick = {
            })
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(vertical = 15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(subs.value, key = SubscriptionModel::id) {
                    SubscriptionItem(model = it, onSubClick = { model ->

                    })
                }
            }
        }
    }
}

@Composable
private fun SubscriptionItem(
    model: SubscriptionModel,
    onSubClick: (SubscriptionModel) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = PrimaryColor), onClick = {
            onSubClick(model)
        }
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            if (model.isBasic) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sub_info),
                    contentDescription = "", modifier = Modifier
                        .padding(end = 5.dp)
                        .size(30.dp)
                        .align(Alignment.TopEnd)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(top = 10.dp, bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = model.title, style = Typography.labelLarge)
                Text(
                    text = "Price: ${model.price}\nNumber of trainings: ${model.numberOfTrainings}\nPaid: ${if (model.isPaid) "Yes" else "No"}\nThe number of training sessions used: ${model.numberOfTrainingSeasonUsed}",
                    style = Typography.labelSmall.copy(
                        textAlign = TextAlign.Center, fontSize = TextUnit(
                            15f,
                            TextUnitType.Sp
                        )
                    ),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
private fun SubscriptionPreview() {
    SubscriptionScreenContent(rememberNavController())
}