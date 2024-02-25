package project.environment.carby.transport

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun TransportJourney(navController: NavController) {


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
    Column(modifier = Modifier.fillMaxSize()) {

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


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            JourneyCards(title = "Car", image = R.drawable.redcar) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }
                            JourneyCards(title = "Bus", image = R.drawable.bus) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }
                            JourneyCards(title = "Train", image = R.drawable.train) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            JourneyCards(title = "Carpool", image = R.drawable.car) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }
                            JourneyCards(title = "Motorbike", image = R.drawable.cycle) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }
                            JourneyCards(title = "Walk", image = R.drawable.walk) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            JourneyCards(title = "E-scooter", image = R.drawable.skating) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }
                            JourneyCards(title = "Bicycle", image = R.drawable.bicycle) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }
                            JourneyCards(title = "", image = R.drawable.add) {
                                navController.navigate(Screens.TransportJourneyTime.route)
                            }

                        }

                    }

                }
            }
        }

    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun JourneyCards(
    title: String, image: Int, modifier: Modifier = Modifier, onClick: () -> Unit
) {

    Column(
        modifier = Modifier
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        androidx.compose.material.Card(
            modifier = modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .size(63.9.dp), onClick = onClick
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = title, modifier = Modifier.padding(15.7.dp), fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 12.sp
        )
    }
}