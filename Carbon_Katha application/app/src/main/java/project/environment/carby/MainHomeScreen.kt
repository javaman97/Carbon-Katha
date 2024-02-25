package project.environment.carby

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import project.environment.carby.food.RecipeCard
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.GreenLight
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow

@Composable
fun MainHomeScreen(navHostController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Dashboard()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Choose your way to combat carbon emission crisis", fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                MainHomeScreenButton(text = "Food", img = R.drawable.food) {
                    navHostController.navigate(Screens.FoodHomeScreen.route)
                }

                MainHomeScreenButton(text = "Fashion", img = R.drawable.fashion) {
                    navHostController.navigate(Screens.FashionStart.route)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                MainHomeScreenButton(text = "Transport", img = R.drawable.transport) {
                    navHostController.navigate(Screens.TransportJourney.route)
                }
                MainHomeScreenButton(text = "Technology", img = R.drawable.technology) {
                    navHostController.navigate(Screens.Technology.route)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.fillMaxWidth(0.60f)) {
                androidx.compose.material.Text(
                    text = "Slice your carbon emissions, one bite at a time",
                    fontSize = 15.sp,
                )
            }


            NeonYellowButton(
                height = 17,
                width = 82,
                size = 8,
                text = "Explore More",
                onClick = {
                    navHostController.navigate(Screens.FoodRecipe.route)
                }
            )

        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            items(5) { index ->

                MainHomeLazyCards()

            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.fillMaxWidth(0.60f)) {
                androidx.compose.material.Text(
                    text = "Elevate your style, lower your carbon profile",
                    fontSize = 15.sp,
                )
            }


            NeonYellowButton(
                height = 17,
                width = 82,
                size = 8,
                text = "Explore More",
                onClick = {
                    navHostController.navigate(Screens.FoodRecipe.route)
                }
            )

        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            items(5) { index ->

                MainHomeLazyCards()

            }
        }









        Spacer(modifier = Modifier.height(100.dp))
        //ends

    }

}


@Composable
fun MainHomeLazyCards() {
    androidx.compose.material.Card(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .padding(8.dp)
            .width(90.89.dp)
            .height(108.92.dp),

        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.65f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.recipeimg),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
         Row (modifier = Modifier.fillMaxWidth()){
             Row(
                 modifier = Modifier
                     .fillMaxWidth()
                     .background(color = MainGreen)
                     .padding(vertical = 5.dp, horizontal = 2.dp),
                 horizontalArrangement = Arrangement.Center,
                 verticalAlignment = Alignment.CenterVertically
             ) {
                 androidx.compose.material.Text(
                     text = "Try new recipes to shrink your carbon footprint",
                     textAlign = TextAlign.Center,
                     fontSize = 8.sp,
                     color = Color.White,
                     fontWeight = FontWeight.Normal
                 )
             }
         }
        }
    }
}


@Composable
fun MainHomeScreenButton(text: String, img: Int, onClick: () -> Unit) {


    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(33.dp))
            .clickable { onClick() }
            .height(130.dp)
            .width(150.dp),
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(100f), Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,

                )
            androidx.compose.material.Text(
                text = text,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 22.dp)
            )
        }


    }

}


@Composable
fun Dashboard() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 26.dp, bottomEnd = 26.dp))
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MainGreen),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.4f)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .width(35.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = NeonYellow),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "45 kg",
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "CO2 so far this month",
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontSize = 12.sp,
                            lineHeight = 12.sp
                        )
                    }

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .width(35.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = NeonYellow),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "53%",
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "CO2 so far this month",
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontSize = 12.sp,
                            lineHeight = 12.sp
                        )
                    }

                }

            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 25.dp)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {


                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.fillMaxWidth(0.60f)) {
                        Text(
                            text = "Daily Carbon Footprint",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }
                    Card(modifier = Modifier.size(80.dp), shape = CircleShape) {
Image(painter = painterResource(id = R.drawable.userimg), contentDescription ="", modifier = Modifier.fillMaxSize() )
                    }

                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "2 % lesser than average daily count", fontSize = 13.sp, color = Color.White)
                }

            }


        }
    }
}

//@Preview
//@Composable
//fun MainHomeScreenPreview() {
//    val navController = rememberNavController()
//    MainHomeScreen(navController = navController)
//}