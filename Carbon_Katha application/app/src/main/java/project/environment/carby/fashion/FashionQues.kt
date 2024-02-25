package project.environment.carby.fashion

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import project.environment.carby.R
import project.environment.carby.food.LightGreenButton
import project.environment.carby.navigation.Screens

@Composable
fun FashionQues(navController: NavHostController) {

    var selectedFrequency by remember { mutableStateOf("every week") }
    var selectedLaundry by remember { mutableStateOf("cold water") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        MCQQUes(
            qu = "How often do you buy clothing?",
            op1 = "every week",
            op2 = "every month",
            op3 = "every year",
            selected = selectedFrequency,
            onSelect = { selectedFrequency = it }
        )

        MCQQUes(
            qu = "Tell us about your laundry habits",
            op1 = "cold water",
            op2 = "warm water",
            op3 = "give outside",
            selected = selectedLaundry,
            onSelect = { selectedLaundry = it }
        )



        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LightGreenButton(text = "Save"){
                navController.navigate(Screens.FashionHomeScreen.route)
            }
        }
    }

}

@Composable
fun MCQQUes(
    qu: String,
    op1: String,
    op2: String,
    op3: String,
    selected: String,
    onSelect: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = qu,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected == op1,
                onClick = { onSelect(op1) },
                modifier = Modifier.weight(1f)
            )
            Text(
                text = op1,
                modifier = Modifier.weight(4f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected == op2,
                onClick = { onSelect(op2) },
                modifier = Modifier.weight(1f)
            )
            Text(
                text = op2,
                modifier = Modifier.weight(4f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected == op3,
                onClick = { onSelect(op3) },
                modifier = Modifier.weight(1f)
            )
            Text(
                text = op3,
                modifier = Modifier.weight(4f)
            )
        }
    }
}
