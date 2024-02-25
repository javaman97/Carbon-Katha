package project.environment.carby.food

import android.icu.text.MessagePattern.ArgType
import android.widget.Space
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.HorizontalRule
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.R
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow

@Composable
fun GroceryList(navController: NavHostController) {

    var nameValue = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 10.dp)
            .padding(top = 10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 15.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material.Text(
                text = "Grocery List",
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal
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
                    androidx.compose.material.Text(
                        text = "Use up what you already have",
                        color = Color.Black,

                        )
                },
                placeholder = {
                    androidx.compose.material.Text(
                        text = "Search Ingredients",
                        fontSize = 14.sp,
                        color = MainGreen
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f).size(60.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {

            IngredientCards(
                ingre = "Cow Milk",
                Co2 = "1.9 Kg Co2 per Litres",
                quantity = "2",
                icon = Icons.Default.Add,
                colour = Color.White
            )

           IngredientYellowCard(
               ingre1 = "Oat Milk",
               ingre2 = "Soy Milk",
               Co21 = "0.39 kilograms of CO2",
               Co22 = "0.45 kilograms of CO2",
               icon1 =  Icons.Default.HorizontalRule,
               icon2 =  Icons.Outlined.HorizontalRule,
               qu1 = "",
               qu2 = ""
           )

            Spacer(modifier = Modifier.height(30.dp))

            IngredientCards(
                ingre = "Paneer",
                Co2 = "1.9 Kg Co2 per Litres",
                quantity = "2",
                icon = Icons.Default.Add,
                colour = Color.White
            )
            IngredientYellowCard2()


        }


    }
}


@Composable
fun IngredientCards(
    ingre: String,
    Co2: String,
    quantity: String,
    icon: ImageVector,
    colour: Color
) {
   Row (modifier = Modifier
       .fillMaxWidth()
       .padding(bottom = 5.dp)){
       Card(
           modifier = Modifier
               .clip(RoundedCornerShape(15.dp))
               .height(40.56.dp), elevation = 30.dp
       ) {
           Row(
               modifier = Modifier
                   .clip(RoundedCornerShape(15.dp))
                   .fillMaxSize()
                   .background(color = colour),
               horizontalArrangement = Arrangement.SpaceAround,
               verticalAlignment = Alignment.CenterVertically
           ) {
               Text(
                   text = ingre,
                   fontSize = 15.7.sp,
                   fontWeight = FontWeight.SemiBold,
                   color = Color.Black
               )
               Text(
                   text = Co2,
                   fontSize = 11.3.sp,
                   fontWeight = FontWeight.Light,
                   color = Color.Black
               )
               Text(
                   text = quantity,
                   fontSize = 15.7.sp,
                   fontWeight = FontWeight.SemiBold,
                   color = Color.Black
               )

               Icon(
                   icon,
                   contentDescription = "Add",
                   modifier = Modifier.size(20.dp),
                   tint = Color.Black,
               )
           }
       }
   }
}


@Composable
fun IngredientYellowCard( ingre1:String, ingre2:String, Co21:String, Co22:String, icon1: ImageVector, icon2:ImageVector,qu1:String, qu2:String) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(13.5.dp))
            .height(147.9.dp), elevation = 40.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = NeonYellow),

            ) {

            Column(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                ) {

                    Icon(
                        Icons.Default.Info,
                        contentDescription = "Add",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "considered opting for greener choices?\n" +
                                " Add these instead",
                        fontSize = 11.3.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black,
                        lineHeight = 15.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                IngredientCards(
                    ingre = ingre1,
                    Co2 = Co21,
                    quantity = qu1,
                    icon = icon1,
                    colour = Color.White
                )
                IngredientCards(
                    ingre = ingre2,
                    Co2 = Co22,
                    quantity = qu2,
                    icon =icon2,
                    colour = Color.White
                )
            }
        }
    }
}

@Composable
fun IngredientYellowCard2() {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(13.5.dp))
            .height(100.9.dp), elevation = 40.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = NeonYellow),

            ) {

            Column(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                ) {

                    Icon(
                        Icons.Default.Info,
                        contentDescription = "Add",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "considered opting for greener choices?\n" +
                                " Add these instead",
                        fontSize = 11.3.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black,
                        lineHeight = 15.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                IngredientCards(
                    ingre = "Tofu",
                    Co2 = "0.39 kilograms of CO2",
                    quantity = "",
                    icon = Icons.Default.HorizontalRule,
                    colour = Color.White
                )

            }
        }
    }
}