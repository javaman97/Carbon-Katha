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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.R
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.LightBlue
import project.environment.carby.ui.theme.White

@Composable
fun RecipeDetails(navController: NavHostController) {


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

    Column(modifier = Modifier.fillMaxSize()
        .clickable { navController.navigate(Screens.RecipeDetailsAlternate.route) }) {

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

                               Card {
                                   Text(
                                       "Ingredients",
                                       fontSize = 15.7.sp,
                                       fontWeight = FontWeight.Medium
                                   )
                               }
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth(0.5f)


                        ) {
                           Card ( modifier = Modifier){
                               Text(
                                   "Instructions",
                                   fontSize = 15.7.sp,
                                   fontWeight = FontWeight.Medium,

                               )
                           }
                        }

                    }}

                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(5.dp)
                        .padding()
                ) {
                    Divider(modifier = Modifier, color = LightBlue, thickness = 3.dp)
                }
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp)
                    ) {


                        Text(
                            text = "\n" + "4 slices of bread (whole wheat or sourdough) [whole wheat or sourdough bread made from locally sourced grains if available]\n" + "1 cup fresh spinach leaves, washed and dried [1 cup fresh spinach leaves from a local farmer's market or homegrown]\n" + "1 cup shredded cheese (cheddar, mozzarella, or your favorite melting cheese) [Locally produced cheese, such as cheddar from nearby farms or plant-based cheese alternatives]\n" + "2 tablespoons butter, softened [2 tablespoons olive oil or plant-based spread]\n" + "Salt and pepper to taste\n" + "Optional: sliced tomato or avocado for added flavor [Locally grown tomatoes or avocados if in season, or omit if not available]",
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}