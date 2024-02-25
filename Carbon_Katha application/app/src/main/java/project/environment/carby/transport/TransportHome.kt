package project.environment.carby.transport

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
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BlurCircular
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.R
import project.environment.carby.fashion.DefaultGreenButton
import project.environment.carby.food.IngredientCards
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow
import project.environment.carby.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransportHome(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(35.dp))
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

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
            ) {
                TransportCard(round = 15.dp, descrip = "Enter Starting point ", Icon = Icons.Default.BlurCircular)
                TransportCard(round = 15.dp, descrip = "Enter Destination ", Icon = Icons.Default.LocationOn)
                TransportCard(round = 0.dp, descrip = "1 Adult", Icon = Icons.Default.Add)
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 45.dp)
                .padding(end = 45.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Find least carbon emitting transport facility for your journey",
                fontSize = 20.28.sp,
                lineHeight = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(13.dp))
                    .width(120.46.dp)
                    .height(45.30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
                    .clickable { navController.navigate(Screens.TransportOptions.route) }, // Navigate to the desired destination
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MainGreen),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Get Started",
                        color = White,
                        fontSize = 15.7.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}



@Composable
fun TransportCard(round: Dp, descrip: String, Icon: ImageVector) {

    var nameValue = remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp)
    ) {
        androidx.compose.material.Card(
            modifier = Modifier
                .clip(RoundedCornerShape(round))
                .height(60.56.dp), elevation = 30.dp
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(round))
                    .fillMaxSize()
                    .background(color = NeonYellow),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(modifier = Modifier.fillMaxWidth(0.8f).padding(vertical = 1.dp)) {
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = {   nameValue.value = it},
                        label = { Text(text = descrip) },
                        placeholder = { /* No placeholder */ },
                        colors = TextFieldDefaults.outlinedTextFieldColors(cursorColor = Color.Black),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }


                Icon(
                    Icon,
                    contentDescription = "Add",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Black,

                    )
            }
        }


    }
}