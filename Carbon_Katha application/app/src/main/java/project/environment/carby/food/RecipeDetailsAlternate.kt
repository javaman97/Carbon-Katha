package project.environment.carby.food

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlignVerticalCenter
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Timer
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
import androidx.navigation.NavController
import project.environment.carby.R
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.LightBlue
import project.environment.carby.ui.theme.NeonYellow


@Composable
fun RecipeDetailsAlternate(navController: NavController) {


    Box(
        modifier = Modifier, contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.recipesquare),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(307.23.dp),
            contentScale = ContentScale.FillBounds
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 250.dp)
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(19.dp))
                            .width(252.dp)
                            .height(83.dp), elevation = 10.dp
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "RECIPE", color = Color.Black, fontSize = 15.sp)
                            Text(
                                text = "Egg cheese recipe",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }


                }



                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "20 mins",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }

                Column(modifier = Modifier.fillMaxWidth()) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding()
                        ) {

                            Text(
                                "Ingredients",
                                fontSize = 15.7.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.clickable{ navController.navigate(Screens.RecipeDetails.route)}
                            )
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth(0.5f)

                        ) {
                            Text(
                                "Instructions",
                                fontSize = 15.7.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }}

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .padding()
                ) {
                    Divider(modifier = Modifier.fillMaxWidth(0.5f), color = Color.Transparent, thickness = 3.dp)

                    Divider(modifier = Modifier, color = LightBlue, thickness = 3.dp)
                }


                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp)
                    ) {


                        Text(
                            text = "Preheat a skillet or griddle over medium heat.\n" +
                                    "Take two slices of bread and spread butter on one side of each slice.\n" +
                                    "Place the buttered side down on the skillet or griddle.\n" +
                                    "Divide the shredded cheese evenly between the two slices of bread on the skillet.\n" +
                                    "Place a handful of spinach leaves on top of the cheese on each slice.\n" +
                                    "If desired, add slices of tomato or avocado on top of the spinach.\n" +
                                    "Season with salt and pepper to taste.\n" +
                                    "Place the remaining slices of bread on top of each sandwich, buttered side facing up.\n" +
                                    "Cook the sandwiches for 3-4 minutes on each side, or until the bread is golden brown and the cheese is melted.\n" +
                                    "Once done, remove the sandwiches from the skillet or griddle and let them cool for a minute before serving.\n" +
                                    "Cut the sandwiches in half diagonally and serve warm.", fontSize = 15.sp
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .clip(RoundedCornerShape(25.dp))
                                .clickable{ navController.navigate(Screens.FoodWasteDisposalTips.route)}
                                .width(289.dp)
                                .height(82.dp), elevation = 10.dp
                        ) {

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(25.dp))
                                    .fillMaxSize()
                                    .background(color = NeonYellow),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Done making food? , here's how you can dispose of the waste",
                                    modifier = Modifier.fillMaxWidth(0.8f), textAlign = TextAlign.Center
                                )
                                Card(modifier = Modifier.size(40.dp), shape = CircleShape) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color = Color.Black),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Icon(imageVector = Icons.Default.AlignVerticalCenter,contentDescription = "", tint = Color.White )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(100.dp))

                }


            }
        }
    }
}



