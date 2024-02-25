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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun TransportJourneyTime(navController: NavController) {


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
                    painter = painterResource(id = R.drawable.journeypage),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize().clickable{ navController.navigate(Screens.TransportFlight.route)}) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 270.dp),
            contentAlignment = Alignment.Center
        ) {


            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 52.dp, topEnd = 52.dp))
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
                        modifier = Modifier.padding(horizontal = 35.dp, vertical = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        Row (modifier = Modifier
                            .clickable{ navController.navigate(Screens.TransportFlight.route)}
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp, vertical = 3.dp),
                            horizontalArrangement = Arrangement.End){
                            Text(text = "58", fontSize = 21.sp, color= Color.DarkGray, fontWeight = FontWeight.Bold)
                        }
                        Row (modifier = Modifier
                            .clickable{ navController.navigate(Screens.TransportFlight.route)}
                            .padding(horizontal = 30.dp, vertical = 4.dp),
                            horizontalArrangement = Arrangement.End){
                            Text(text = "59", fontSize = 33.sp, color= Color.DarkGray, fontWeight = FontWeight.Bold)
                        }
                        Row (modifier = Modifier
                            .clickable{ navController.navigate(Screens.TransportFlight.route)}
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.Center){

                            Card(modifier = Modifier.width(281.dp).height(70.dp)) {

                                Row (modifier = Modifier
                                    .clickable{ navController.navigate(Screens.TransportFlight.route)}
                                    .fillMaxSize().background(color = Color.Gray),
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    verticalAlignment = Alignment.CenterVertically){
                                    Text(text = "00 hours", fontSize = 21.sp, color= Color.Black, fontWeight = FontWeight.Bold)
                                    Text(text = "0 min", fontSize = 21.sp, color= Color.Black, fontWeight = FontWeight.Bold)

                                }
                            }

                        }


                        Row (modifier = Modifier
                            .clickable{ navController.navigate(Screens.TransportFlight.route)}
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp, vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Text(text = "01", fontSize = 39.sp, color= Color.DarkGray, fontWeight = FontWeight.Bold)
                            Text(text = "58", fontSize = 39.sp, color= Color.DarkGray, fontWeight = FontWeight.Bold)
                        }

                        Row (modifier = Modifier
                            .clickable{ navController.navigate(Screens.TransportFlight.route)}
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp, vertical = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Text(text = "02", fontSize = 30.sp, color= Color.DarkGray, fontWeight = FontWeight.Bold)
                            Text(text = "58", fontSize = 21.sp, color= Color.DarkGray, fontWeight = FontWeight.Bold)
                        }
                        Row (modifier = Modifier
                            .clickable{ navController.navigate(Screens.TransportFlight.route)}
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp, vertical = 3.dp),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Text(text = "03", fontSize = 23.sp, color= Color.DarkGray, fontWeight = FontWeight.Bold)
                            Text(text = "58", fontSize = 21.sp, color= Color.DarkGray, fontWeight = FontWeight.Bold)
                        }


                    }

                }
            }
        }

    }
}

