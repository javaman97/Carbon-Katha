package project.environment.carby.fashion

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import org.w3c.dom.Text
import project.environment.carby.food.ItemCard
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.White

@Composable
fun FashionStart(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp), horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Could you spare a moment to answer a few questions aimed at helping you" +"monitor" +"and reduce your fashion-related emissions?",
                fontSize = 36.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

DefaultGreenButton(text = "Get Started"){
    navController.navigate(Screens.FashionQues.route)
}
        }


    }
}


@Composable
fun DefaultGreenButton(text: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(13.dp))
            .width(170.46.dp)
            .height(45.30.dp)
            .clickable { onClick() }
                .clip(RoundedCornerShape(20.dp))
                .padding(horizontal = 8.dp, vertical = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(13.dp))
                    .background(color = MainGreen),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                androidx.compose.material.Text(text = text, color = White, fontSize = 20.sp, textAlign = TextAlign.Center)
            }
        }

//    }
}