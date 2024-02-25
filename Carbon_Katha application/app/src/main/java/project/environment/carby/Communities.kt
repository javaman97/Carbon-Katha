package project.environment.carby

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.fashion.FashionBar
import project.environment.carby.fashion.FashionFeedCard
import project.environment.carby.ui.theme.NeonYellow

@Composable
fun Communities(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 15.dp, bottom = 2.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(text = "Communities", fontSize = 30.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Come forward and be a part of change")

        }


        Spacer(modifier = Modifier.height(15.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 15.dp, bottom = 2.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(text = "Leading Communities", fontSize = 20.sp)


        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(5) { index ->
                CommunityCard(text = "Join our vibrant community", img = R.drawable.commu2)
                CommunityCard(
                    text = "20 Best Ways to Reuse Old Clothing With Helpful Tutorials",
                    img = R.drawable.commu3
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 10.dp, bottom = 2.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(text = "Supporting New Beginnings", fontSize = 20.sp)


        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(5) { index ->
                CommunityCard(text = "One cloth at a time", img = R.drawable.fashiontips)
                CommunityCard(
                    text = "Best tipc and tricks",
                    img = R.drawable.fashion
                )
            }
        }

        Spacer(modifier = Modifier.height(70.dp))
    }
}


@Composable
fun CommunityCard(text: String, img: Int) {

    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .width(220.dp)
            .height(250.dp),

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

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize(0.8f)
                        .padding(horizontal = 5.dp, vertical = 5.dp)
                ) {

                    Image(
                        painter = painterResource(id = img),
                        contentDescription = "",
                        modifier = Modifier.size(150.dp),
                        contentScale = ContentScale.FillBounds
                    )

                }


            }

            Spacer(modifier = Modifier.height(2.dp))



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 3.dp, end = 8.dp)
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                    Card (modifier= Modifier.fillMaxWidth(0.8f)){
                        Text(
                            text = text,
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                        Card (modifier = Modifier){
                            Icon(imageVector = Icons.Default.Favorite, contentDescription ="" , tint = Color.Red)

                        }
                }


            Spacer(modifier = Modifier.height(5.dp))

        }
    }

}
