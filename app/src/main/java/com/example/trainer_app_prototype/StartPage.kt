package com.example.trainer_app_prototype
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun StartPage(){
    Surface(color=Color(R.color.pozadie)) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_stamp),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )


            Surface(color = Color(R.color.pozadieblede)) {
               // modifier = Modifier.padding(20.dp, 20.dp)
                Column {
                    var ButtKlient = createButton(tagOfButton = "klient")
                    Spacer(modifier = Modifier.height(20.dp))
                    var ButtTrener = createButton(tagOfButton = "trener")
                }
            }




            }

        }
    }
@Composable
fun createButton(tagOfButton: String){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            .size(50.dp),
        colors = ButtonDefaults.buttonColors()
    ) {
        Text(text = tagOfButton)

    }

}

