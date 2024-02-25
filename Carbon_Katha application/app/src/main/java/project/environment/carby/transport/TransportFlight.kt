package project.environment.carby.transport

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import project.environment.carby.NeonYellowButton
import project.environment.carby.R
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.MainGreen

@Composable
fun TransportFlight(navController: NavController) {


    Box(
        modifier = Modifier, contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MainGreen),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.journeyflight),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 360.dp),
            contentAlignment = Alignment.Center
        ) {


            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(30.dp))
                    Column(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 25.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        AdderIcon(text1 = "Short", text2 = " Upto 3 hours long", img = R.drawable.img, navController = navController)
                        AdderIcon(text1 = "Medium", text2 = "3 - 6 hours long", img = R.drawable.img, navController = navController)
                        AdderIcon(text1 = "Long", text2 = "6+ hours long", img = R.drawable.img, navController = navController)
                    }

                }
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdderIcon(text1:String, text2:String, img:Int,navController: NavController
) {

        var value by remember { mutableStateOf(1) } // State variable to hold the value

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 3.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .clickable { navController.navigate(Screens.TransportHome.route) }
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .size(50.dp),
            ) {
                Image(
                    painter = painterResource(img),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()

                )
            }

            Column (modifier = Modifier      .clickable { navController.navigate(Screens.TransportHome.route) }){
                Text(
                    text = text1,
                    fontSize = 22.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = text2,
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Light
                )
            }

            Spacer(modifier = Modifier.width(30.dp))

            // Add icon
            Card(
                modifier = Modifier.size(30.dp),
                onClick = { value++ } // Increase value by 1 when clicked
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Text(
                text = "$value", // Display the value
                fontSize = 20.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Light
            )

            // Horizontal rule icon
            Card(
                modifier = Modifier.size(30.dp),
                onClick = { if (value > 0) value-- } // Decrease value by 1 when clicked, but only if value > 0
            ) {
                Icon(
                    imageVector = Icons.Default.HorizontalRule,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

}