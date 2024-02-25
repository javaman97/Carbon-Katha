package project.environment.carby.fashion

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.R
import project.environment.carby.circularprogressbar.CircularProgressBar
import project.environment.carby.food.RecipeCard
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.GreenLight
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow




@Composable
fun FashionHomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 15.dp, bottom = 8.dp)
            ) {
                Text(text = "Good Evening, Nandini!", fontSize = 24.sp)
            }




            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 5.dp)
            ) {

                FashionSearchBar(text = "See what’s popular today")
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp, vertical = 10.dp)
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressBar(
                    percentage = 0.8f,
                    image = R.drawable.fashioncircle,
                    number = 100
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    androidx.compose.material3.Text(
                        text = "34 Kg CO2",
                        fontSize = 27.04.sp,
                        fontWeight = FontWeight.Bold
                    )
                    androidx.compose.material3.Text(
                        text = "so far this month",
                        fontSize = 15.02.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = GreenLight
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MainGreen)
            ) {
                //green column


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 15.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .width(264.4.dp)
                            .clickable { navController.navigate(Screens.FashionFeed.route) } // Use clickable with lambda
                            .height(144.2.dp)
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = NeonYellow),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    text = "Explore eco-friendly DIY and upcycled projects in our community.",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.7.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth(0.7f),
                                )


                                Card(modifier = Modifier.size(25.dp), shape = CircleShape) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color = Color.Black),
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowForward,
                                            contentDescription = "",
                                            modifier = Modifier.fillMaxSize(),
                                            tint = Color.White
                                        )
                                    }
                                }
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 40.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Card(modifier = Modifier.size(55.dp), shape = CircleShape) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color = NeonYellow)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.People,
                                            contentDescription = "",
                                            modifier = Modifier.fillMaxSize(),
                                            tint = Color.Black
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                FashionButtonRow(navController = navController)

                Spacer(modifier = Modifier.height(55.dp))
            }
        }
    }
}

@Composable
fun FashionButtonRow(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        FashionButtons(
            text = "Ask ChatBot for assistance",
            img = R.drawable.fashionh1,
            destination = Screens.ChatBot.route,
            navController = navController
        )
        Spacer(modifier = Modifier.width(16.dp))
        FashionButtons(
            text = "Explore monthly fashion impact challenges and wardrobe swapping events",
            img = R.drawable.fashionh2,
            destination = Screens.Communities.route,
            navController = navController
        )
    }
}

@Composable
fun FashionButtons(text: String, img: Int, destination: String, navController: NavController) {
    Button(
        onClick = { navController.navigate(destination) }, // Correct usage of navController.navigate()
        modifier = Modifier
            .clip(RoundedCornerShape(27.dp))
            .height(200.dp) // Adjust the height here as per your requirement
            .width(155.dp),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = GreenLight
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = text,
                textAlign = TextAlign.Justify,
                fontSize = 15.02.sp,
                color = Color.White
            )
        }
    }
}



@Composable
fun FashionSearchBar(text: String,) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .height(57.8.dp),
            elevation = 30.dp
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxSize()
                    .background(color = NeonYellow),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    fontSize = 15.7.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
                IconButton(
                    onClick = { /* Handle search icon click */ },
                    modifier = Modifier.size(40.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
            }
        }
    }
}
