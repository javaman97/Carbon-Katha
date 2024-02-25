package project.environment.carby.food

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.GreenLight
import project.environment.carby.ui.theme.White

@Composable
fun FoodRecipe(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 15.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Recipes", fontSize = 30.4.sp)


                Card(
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .height(20.02.dp)
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

        Spacer(modifier = Modifier.height(15.dp))
        Column (modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            RecipeCard(navController = navController)
            RecipeCard(navController = navController)
            RecipeCard(navController = navController)
            RecipeCard(navController = navController)
            RecipeCard(navController = navController)
        }


Spacer(modifier = Modifier.height(100.dp))
    }

}