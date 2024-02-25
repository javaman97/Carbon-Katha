package project.environment.carby.transport

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow
import project.environment.carby.ui.theme.traGreen
import project.environment.carby.ui.theme.traRed
import project.environment.carby.ui.theme.traYellow

@Composable
fun TransportOptions(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MainGreen),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Suggested transportation",
                fontSize = 18.02.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)){
           TransOpCard(descrip = "EV", qu = "20 Kg Co2", colour = traGreen)
            TransOpCard(descrip = "Bus", qu = "30 Kg Co2", colour = traGreen)
            TransOpCard(descrip = "Airplane", qu = "40 Kg Co2", colour = traYellow)
            TransOpCard(descrip = "Petrol Car", qu = "50 Kg Co2", colour = traYellow)
            TransOpCard(descrip = "Train", qu = "60 Kg Co2", colour = traRed)
            TransOpCard(descrip = "Diesel Car", qu = "60 Kg Co2", colour = traRed)


        }
    }
}


@Composable
fun TransOpCard(descrip: String, qu: String, colour: Color) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        androidx.compose.material.Card(
            modifier = Modifier
                .clip(RoundedCornerShape(15.2.dp))
                .height(50.56.dp), elevation = 30.dp
        ) {
            Row (
                modifier = Modifier
                    .clip(RoundedCornerShape(15.2.dp))
                    .fillMaxSize()
                    .background(color = colour),){
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.2.dp))
                        .fillMaxSize().padding(horizontal = 18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = descrip,
                        fontSize = 15.7.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Text(
                        text = qu,
                        fontSize = 15.7.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )


                }
            }

        }


    }
}
