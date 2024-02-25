package project.environment.carby.food

import androidx.compose.foundation.background
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
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.ui.theme.MainGreen

@Composable
fun FoodAI(navController: NavHostController) {

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
            Text(
                text = "Explore Knowledge with AI Chat",
                fontSize = 40.sp,
                fontWeight = FontWeight.Medium
            )

        }

        Spacer(modifier = Modifier.height(15.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {


            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .fillMaxWidth()
                    .height(60.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Yellow),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "New Chat", fontSize = 22.sp, color = Color.Gray,
                        textAlign = TextAlign.Start, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(horizontal = 15.dp)
                    )

                    Card(modifier = Modifier.size(40.dp), shape = CircleShape) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "", modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp)
                        )
                    }

                }
            }
        }



        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),

            ) {


                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    Text(
                        text = "Recommended for you",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .clip(RoundedCornerShape(14.dp))
                            .height(35.dp)
                    ) {
                        Text(text = "Filter By", textDecoration = TextDecoration.Underline)
                    }

                }

                Spacer(modifier = Modifier.height(30.dp))


            }
        }

    }
}
