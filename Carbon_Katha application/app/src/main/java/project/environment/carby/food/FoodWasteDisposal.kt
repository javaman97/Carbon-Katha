package project.environment.carby.food

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import project.environment.carby.R
import project.environment.carby.fashion.DefaultGreenButton

@Composable
fun FoodWasteDisposal(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 15.dp)
            .padding(top = 10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Select Type of Waste",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            ItemCard(ingredient = "waste", img = R.drawable.waste1)
            ItemCard(ingredient = "waste", img = R.drawable.waste2)
            ItemCard(ingredient = "waste", img = R.drawable.waste3)
        }

        Spacer(modifier = Modifier.height(55.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp), horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Find waste disposal sites that turn trash into treasure.",
                fontSize = 30.sp, lineHeight = 40.sp, fontWeight = FontWeight.Bold, color = Color.Gray
            )
        }

        Row ( modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp).padding(top = 40.dp), horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically){

          DefaultGreenButton(text = "Get Started") {


          }
        }


    }
}