package project.environment.carby.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.R
import project.environment.carby.circularprogressbar.CircularProgressBar
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.GreenLight
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.White


@Composable
fun FoodHomeScreen(navController: NavHostController) {
    var nameValue = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
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
                Text(text = "Good Evening, Nandini!", fontSize = 20.sp)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)

            ) {
                Text(
                    text = "What's in your fridge?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp, horizontal = 10.dp)
                    .clickable { navController.navigate(Screens.FoodSearch.route) } ,
                horizontalArrangement = Arrangement.Center ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                value = nameValue.value,
                colors = TextFieldDefaults.textFieldColors (Color.Black),
                onValueChange = {
                    nameValue.value = it
                },
                label = {
                    Text(
                        text = "Use up what you already have",
                        color = Color.Black,

                        )
                },
                placeholder = { Text(text = "Search Ingredients", fontSize = 14.sp, color = MainGreen) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f).size(60.dp)
            )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp, vertical = 10.dp)
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressBar(percentage = 0.8f, image = R.drawable.foodcircle, number = 100)
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

        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MainGreen)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                HomeButtonRow1(navController = navController)
                HomeButtonRow2(navController = navController)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 4.dp)
                        .padding(top = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Recommended for you",
                        fontSize = 18.02.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = White
                    )
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(14.dp))
                            .height(20.02.dp)
                            .clickable { navController.navigate(Screens.FoodRecipe.route) }
                            .width(60.08.dp)
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .background(GreenLight), horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {
                            Text(
                                text = "Filter By",
                                fontSize = 10.sp,
                                textDecoration = TextDecoration.Underline,
                                color = White
                            )

                        }
                    }

                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp)
                ) {
                    items(5) { index ->

                        RecipeCard(navController = navController)

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 5.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LightGreenButton(text = "Load More"){
                        navController.navigate(Screens.FoodSearch.route)
                    }

                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                }

                Spacer(modifier = Modifier.height(100.dp))


            }
        }

    }
}


@Composable
fun RecipeCard(navController: NavController) {
   Row(modifier = Modifier
       .padding(horizontal = 5.dp, vertical = 5.dp)
       .padding(end = 5.dp)) {
       Card(
           modifier = Modifier
               .clip(RoundedCornerShape(50.7.dp))
               .height(271.17.dp)
               .width(241.12.dp),

           shape = RoundedCornerShape(16.dp)
       ) {
           Column(modifier = Modifier
               .clip(RoundedCornerShape(50.7.dp))
               .fillMaxSize()) {
               Row(
                   modifier = Modifier

                       .fillMaxWidth()
                       .fillMaxHeight(0.7f)
               ) {
                   Image(
                       painter = painterResource(id = R.drawable.recipeimg),
                       contentDescription = "",
                       modifier = Modifier.fillMaxSize(),
                       contentScale = ContentScale.FillBounds
                   )
               }

               Column(modifier = Modifier
                   .fillMaxSize()
                   .background(color = MainGreen)) {

                   Spacer(modifier = Modifier.height(5.dp))
                   Row(
                       modifier = Modifier
                           .clip(RoundedCornerShape(bottomStart =  50.7.dp, bottomEnd = 50.7.dp))
                           .fillMaxWidth()
                           .padding(vertical = 5.dp),
                       horizontalArrangement = Arrangement.Center,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(
                           text = "Egg cheese sandwich",
                           textAlign = TextAlign.Center,
                           fontSize = 16.sp,
                           fontWeight = FontWeight.SemiBold,
                           color = White
                       )
                   }
                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(horizontal = 10.dp, vertical = 1.dp)
                           .padding(bottom = 6.dp),
                       horizontalArrangement = Arrangement.Center
                   ) {
                       Card(
                           modifier = Modifier
                               .clip(RoundedCornerShape(13.dp))
                               .width(140.46.dp)
                               .clickable{ navController.navigate(Screens.RecipeDetails.route)}
                               .height(35.30.dp)
                               .clip(RoundedCornerShape(20.dp))
                               .padding(horizontal = 8.dp, vertical = 2.dp)
                       ) {
                           Column (modifier = Modifier
                               .fillMaxSize()
                               .background(color = Color.Gray),
                               horizontalAlignment = Alignment.CenterHorizontally,
                               verticalArrangement = Arrangement.Center){
                               Text(text = "Read Recipe", color = White, fontSize = 13.sp, textAlign = TextAlign.Center)
                           }
                       }
                   }
               }
           }
       }
   }
}


@Composable
fun HomeButtonRow1(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        HomeScreenButtons(text = "Track your emissions", img = R.drawable.foodh1, destination = Screens.FoodEmission.route, navController = navController)

        Spacer(modifier = Modifier.width(16.dp))
        HomeScreenButtons(text = "Ask Chatbot", img = R.drawable.foodh2, destination = Screens.ChatBot.route, navController = navController)
    }
}

@Composable
fun HomeButtonRow2(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        HomeScreenButtons(text = "Grocery List", img = R.drawable.foodh3, destination = Screens.GroceryList.route, navController = navController)

        Spacer(modifier = Modifier.width(16.dp))
        HomeScreenButtons(text = "Waste Disposal", img = R.drawable.foodh4, destination = Screens.FoodWasteDisposalTips.route, navController = navController)
    }
}



@Composable
fun HomeScreenButtons(text: String, img: Int, destination: String, navController: NavController) {
    Button(
        onClick = { navController.navigate(destination) },
        modifier = Modifier
            .clip(RoundedCornerShape(27.dp))
            .height(160.dp)
            .width(150.dp),
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
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 15.02.sp,
                color = Color.White
            )
        }
    }
}
