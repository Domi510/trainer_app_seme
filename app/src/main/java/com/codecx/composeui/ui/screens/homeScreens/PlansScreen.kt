package com.codecx.composeui.ui.screens.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codecx.composeui.R
import com.codecx.composeui.models.PlanModel
import com.codecx.composeui.models.PlanModel.Companion.getTimeInMillis
import com.codecx.composeui.ui.components.TopBar
import com.codecx.composeui.ui.theme.CardColor
import com.codecx.composeui.ui.theme.PrimaryColor
import com.codecx.composeui.ui.theme.StrokeColor
import com.codecx.composeui.ui.theme.Typography
import com.codecx.composeui.utils.UserDataHolder
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@Composable
fun PlansScreen(navController: NavController) {
    PlansScreenContent(navController)
}

@Composable
private fun PlansScreenContent(navController: NavController) {

    val plans = remember {
        derivedStateOf {
            listOf(
                PlanModel(
                    getTimeInMillis(8, 30),
                    getTimeInMillis(9, 30),
                    "Miska N.",
                    2
                ), PlanModel(
                    getTimeInMillis(10, 30),
                    getTimeInMillis(11, 30),
                    "Nika S.",
                    4
                ), PlanModel(
                    getTimeInMillis(11, 30),
                    getTimeInMillis(12, 30),
                    "Matej R.",
                    6
                ), PlanModel(
                    getTimeInMillis(11, 30),
                    getTimeInMillis(12, 30),
                    "Jozef B.",
                    1
                ), PlanModel(
                    getTimeInMillis(15, 30),
                    getTimeInMillis(16, 30),
                    "Dominika",
                    2
                ), PlanModel(
                    getTimeInMillis(10, 30),
                    getTimeInMillis(11, 30),
                    "Nika S.",
                    4
                ), PlanModel(
                    getTimeInMillis(11, 30),
                    getTimeInMillis(12, 30),
                    "Matej R.",
                    6
                ), PlanModel(
                    getTimeInMillis(11, 30),
                    getTimeInMillis(12, 30),
                    "Jozef B.",
                    1
                ), PlanModel(
                    getTimeInMillis(15, 30),
                    getTimeInMillis(16, 30),
                    "Dominika",
                    2
                )
            )
        }
    }
    val currentDate by remember {
        derivedStateOf {
            SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(System.currentTimeMillis())
        }
    }
    val day by remember {
        derivedStateOf {
            val calendar: Calendar = Calendar.getInstance()
            val dayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)
            when (dayOfWeek) {
                Calendar.SUNDAY -> "Nedeľa"
                Calendar.MONDAY -> "Pondelok"
                Calendar.TUESDAY -> "Utorok"
                Calendar.WEDNESDAY -> "Streda"
                Calendar.THURSDAY -> "Štvrtok"
                Calendar.FRIDAY -> "Piatok"
                Calendar.SATURDAY -> "Sobota"
                else -> ""
            }
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
                .padding(bottom = 15.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .padding(horizontal = 10.dp)
                .padding(top = 5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = CardColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        shape = RoundedCornerShape(15.dp),
                        colors = CardDefaults.cardColors(containerColor = PrimaryColor)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = currentDate,
                                style = Typography.labelLarge.copy(fontWeight = FontWeight.Medium)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.arrows),
                                contentDescription = "arrows", modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                    Card(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        shape = RoundedCornerShape(15.dp),
                        colors = CardDefaults.cardColors(containerColor = PrimaryColor)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = day,
                                style = Typography.labelLarge.copy(fontWeight = FontWeight.Medium)
                            )
                        }
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = CardColor)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_time),
                            contentDescription = "", modifier = Modifier
                                .size(20.dp)
                                .weight(1f)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = "", modifier = Modifier
                                .size(20.dp)
                                .weight(1f)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Spacer(
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .size(20.dp)
                        )
                    }
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentPadding = PaddingValues(top = 5.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        items(plans.value) {
                            PlanItem(plan = it)
                        }
                    }
                }
            }
            Text(
                text = "Settings of today training plan", style = Typography.labelSmall.copy(
                    fontSize = TextUnit(
                        12f,
                        TextUnitType.Sp
                    )
                ), modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Add", style = Typography.labelSmall.copy(
                            fontSize = TextUnit(
                                14f,
                                TextUnitType.Sp
                            )
                        )
                    )

                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Edit", style = Typography.labelSmall.copy(
                            fontSize = TextUnit(
                                14f,
                                TextUnitType.Sp
                            )
                        )
                    )

                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Remove", style = Typography.labelSmall.copy(
                            fontSize = TextUnit(
                                14f,
                                TextUnitType.Sp
                            )
                        )
                    )

                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = CardColor)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "NOTES",
                        style = Typography.labelSmall.copy(fontWeight = FontWeight.Medium)
                    )
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(25.dp),
                        contentPadding = PaddingValues(top = 20.dp)
                    ) {
                        items(15) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp)
                                    .background(
                                        StrokeColor
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
private fun PlanItem(plan: PlanModel) {
    val time by remember {

        derivedStateOf {
            "${
                SimpleDateFormat(
                    "hh:mm",
                    Locale.ENGLISH
                ).format(plan.from)
            } - ${SimpleDateFormat("hh:mm", Locale.ENGLISH).format(plan.to)}"
        }
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp),
        shape = RoundedCornerShape(50),
        colors = CardDefaults.cardColors(containerColor = PrimaryColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = time,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = Typography.labelSmall.copy(
                    fontSize = TextUnit(
                        13f,
                        TextUnitType.Sp
                    )
                )
            )
            Text(
                text = plan.name,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = Typography.labelSmall.copy(
                    fontSize = TextUnit(
                        15f,
                        TextUnitType.Sp
                    ), fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = "${plan.score}/10",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = Typography.labelSmall.copy(
                    fontSize = TextUnit(
                        15f,
                        TextUnitType.Sp
                    ), fontWeight = FontWeight.Bold
                )
            )
            Image(
                painter = painterResource(id = R.drawable.info),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 5.dp)
                    .size(20.dp), colorFilter = ColorFilter.tint(plan.InfoColor)
            )
        }
    }
}

@Preview
@Composable
private fun PlansPreview() {
    PlansScreenContent(rememberNavController())
}