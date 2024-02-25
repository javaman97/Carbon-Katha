package project.environment.carby.fashion

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
import androidx.compose.foundation.lazy.LazyRow
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
import project.environment.carby.food.RecipeCard
import project.environment.carby.ui.theme.NeonYellow

@Composable
fun FashionFeed(navController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp)
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
            Text(text = "Feed", fontSize = 28.sp)

//            Row(
//                modifier = Modifier
//                    .width(82.dp)
//                    .height(28.dp)
//            ) {
//                Button(
//                    onClick = { },
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(8.dp))
//                        .padding(0.dp)
//
//                ) {
//                    Text(
//                        text = "Filter By",
//                        fontSize = 10.sp,
//                        textDecoration = TextDecoration.Underline
//                    )
//                }
//            }

        }

        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            items(5) { index ->

                FashionBar(text = " For You")
                FashionBar(text = "Tips & Guides")
                FashionBar(text = "DIY")

            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FashionFeedCard(text ="20 Best Ways to Reuse Old Clothing With Helpful Tutorials", img =  R.drawable.fashiontips)
            FashionFeedCard(text ="20 Best Ways to Reuse Old Clothing With Helpful Tutorials", img =  R.drawable.fashion)
            FashionFeedCard(text ="20 Best Ways to Reuse Old Clothing With Helpful Tutorials", img =  R.drawable.fashiontips)
            FashionFeedCard(text ="20 Best Ways to Reuse Old Clothing With Helpful Tutorials", img =  R.drawable.fashiontips)
            FashionFeedCard(text ="20 Best Ways to Reuse Old Clothing With Helpful Tutorials", img =  R.drawable.fashion)
            FashionFeedCard(text ="20 Best Ways to Reuse Old Clothing With Helpful Tutorials", img =  R.drawable.fashiontips)
        }


    }
}


@Composable
fun FashionFeedCard(text: String,img: Int) {

    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .width(270.dp),

        shape = RoundedCornerShape(39.dp),
        elevation = 30.dp
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 1.dp)
                .padding(top = 15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(285.3.dp)
                    .width(276.4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(0.85f)
                        .padding(horizontal = 5.dp, vertical = 5.dp)
                ) {

                        Image(
                            painter = painterResource(id = img),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )

                }

                Spacer(modifier = Modifier.width(3.dp))
                Column(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fashiont1),
                        contentDescription = "", modifier = Modifier.size(45.dp)

                    )

                    Image(
                        painter = painterResource(id = R.drawable.fashiont2),
                        contentDescription = "", modifier = Modifier.size(45.dp)

                    )
                }


            }

            Spacer(modifier = Modifier.height(2.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 18.dp)
                    .padding(horizontal = 2.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(3.dp))
            }

        }
    }

}


@Composable
fun FashionBar(text: String) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(98.78.dp))
            .height(55.dp)
            .padding(all = 5.dp),
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(98.78.dp))
                .fillMaxSize()
                .background(color = NeonYellow)
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = text,
                fontSize = 15.7.sp,

                )

        }

    }
}