package project.environment.carby.food

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import project.environment.carby.R
import project.environment.carby.ui.theme.NeonYellow

@Composable
fun FoodWasteDisposalTips(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

                .padding(top = 15.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Waste Disposal Tips: EGG", fontSize = 25.04.sp)
        }



        Row( modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 20.dp, vertical = 2.dp)) {
            Image(painter = painterResource(id = R.drawable.compost), modifier = Modifier.size(300.dp), contentDescription = "")
        }

        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .width(389.dp)
                    .height(152.dp), elevation = 10.dp
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
                        text = "Composting: Eggshells are a great addition to compost piles. They add calcium to the soil, which can help plants grow stronger. Crush the eggshells into small pieces before adding them to your compost bin or pile to speed up the decomposition process",
                        modifier = Modifier.fillMaxWidth(0.8f), textAlign = TextAlign.Justify
                    )
                }
            }
        }

        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .width(389.dp)
                    .height(152.dp), elevation = 10.dp
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
                        text = "Gardening: You can crush eggshells and sprinkle them around the base of plants in your garden. This can help deter pests like slugs and snails, which don't like crawling over sharp edges",
                        modifier = Modifier.fillMaxWidth(0.8f), textAlign = TextAlign.Justify
                    )
                }
            }
        }


        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .width(389.dp)
                    .height(152.dp), elevation = 10.dp
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
                        text = "Calcium supplement for plants: ou can also boil eggshells, crush them into a fine powder once they are dry, and then mix the powder into the soil as a natural calcium supplement for plants, especially those that require calcium like tomatoes and peppers",  modifier = Modifier.fillMaxWidth(0.8f), textAlign = TextAlign.Justify
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(100.dp))

    }



}