package project.environment.carby.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.R
import project.environment.carby.fashion.DefaultGreenButton
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.GreenLight
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.White

@Composable
fun FoodSearch(navController: NavHostController) {
    var nameValue = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp)
            .verticalScroll(rememberScrollState())
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

                .padding(top = 15.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Search", fontSize = 30.04.sp)
            Card(modifier = Modifier.size(48.dp), shape = CircleShape) {
                Image(
                    painter = painterResource(id = R.drawable.userimg),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
        }



        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 10.dp)
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
                        text = "select ingredients you have",
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
                .padding(horizontal = 20.dp)
                .padding(top = 15.dp, bottom = 8.dp),
        ) {
            Text(text = "Selected ingredients", fontWeight = FontWeight.Bold)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 15.dp, bottom = 8.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            ItemCard(ingredient = "Egg", img = R.drawable.egg)

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 15.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Select ingredients", fontWeight = FontWeight.Bold)
            Text(
                text = "View All",
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Medium
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 15.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ItemCard(ingredient = "Egg", img = R.drawable.egg)
            ItemCard(ingredient = "Bread", img = R.drawable.bread)
            ItemCard(ingredient = "Tofu", img = R.drawable.tofu)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 5.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            ItemCard(ingredient = "Spinach", img = R.drawable.spinach)
            ItemCard(ingredient = "Potato", img = R.drawable.potato)
            ItemCard(ingredient = "Rice", img = R.drawable.rice)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement


                .Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultGreenButton(text = "Search"){
                navController.navigate(Screens.FoodRecipe.route)
            }

        }
        
        Spacer(modifier = Modifier.height(100.dp))


    }
}


@Composable
fun ItemCard(ingredient: String, img: Int) {

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(88.dp)
                .padding(4.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "", contentScale = ContentScale.FillBounds
            )

        }
        Text(
            text = ingredient,
            fontSize = 20.sp,
            color = GreenLight,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )
    }
}



@Composable
fun LightGreenButton(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp)
            .padding(bottom = 6.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(13.dp))
                .width(160.46.dp)
                .clickable { onClick() }
                .height(47.30.dp)
                .clip(RoundedCornerShape(20.dp))
                .padding(horizontal = 8.dp, vertical = 2.dp)
        ) {
            Column (modifier = Modifier
                .fillMaxSize()
                .background(color = GreenLight),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Text(text = text, color = White, fontSize = 13.sp, textAlign = TextAlign.Center)
            }
        }
    }
}