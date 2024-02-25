package project.environment.carby

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.checkerframework.common.returnsreceiver.qual.This
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow
import java.time.format.TextStyle

@Composable
fun Contribute(navController: NavController) {


    Box(
        modifier = Modifier, contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)) {
            Column(modifier = Modifier.fillMaxSize().background(color = MainGreen),) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp,).padding(top = 30.dp)) {
                    Text(
                        text = "Offsetting Project",
                        fontSize = 30.04.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp,).padding(top = 4.dp)) {
                    Text(
                        text = "We with many Indian projects to procure credits ",
                        fontSize = 11.26.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 115.dp), contentAlignment = Alignment.Center
        ) {

            Card(modifier = Modifier.clip(RoundedCornerShape(topStart = 52.dp, topEnd = 52.dp)).fillMaxSize()) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {


                        Image(
                            painter = painterResource(id = R.drawable.contri),
                            contentDescription = "",
                            modifier = Modifier.size(250.dp)
                        )
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 7.dp)) {
                            Text(
                                text = "Tree plantation in Mumbai",
                                fontSize = 22.53.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)) {
                            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "", tint = Color.Black)
                            Text(
                                text = "Mumbai",
                                fontSize = 24.03.sp,
                                fontWeight = FontWeight.Light,
                                color = Color.Black
                            )
                        }

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)) {

                            Text(
                                text = "Be a part of the green movement and make Mumbai lush again by joining our Tree Plantation Drive – together, let's nurture a sustainable future for generations to come!",
                                fontSize = 11.26.sp,
                                fontWeight = FontWeight.Light,
                                        color = Color.Black,
                                lineHeight = 20.sp,
                                textAlign = TextAlign.Justify
                            )
                        }


                        Row(modifier = Modifier
                            .fillMaxWidth().padding(vertical = 5.dp).padding(bottom = 5.dp),
                            horizontalArrangement = Arrangement.Center
                          ) {
                            Text(
                                text = "\$2.08 / 100kg ",
                                fontSize = 30.04.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            NeonYellowButton(
                                height = 58,
                                width = 150,
                                size = 16,
                                text = "More Details",
                                onClick = {
//                                    navController.navigate(Screens.FashionStart.route)
                                }
                            )


                            Spacer(modifier = Modifier.width(8.dp))


                            NeonYellowButton(
                                height = 58,
                                width = 150,
                                size = 16,
                                text = "Purchase Offers",
                                onClick = {
//                                    navController.navigate(Screens.FashionStart.route)
                                }
                            )


                        }
                    }
                }
            }

        }
    }
}


@Composable
fun NeonYellowButton(
    height: Int,
    width: Int,
    size: Int,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(23.dp))
            .height(height.dp)
            .width(width.dp)
            .clickable(onClick = onClick) // Use onClick parameter directly
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = NeonYellow),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = size.sp,
                color = Color.Black,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
