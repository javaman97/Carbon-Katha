package project.environment.carby.food

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import project.environment.carby.fashion.MCQQUes
import project.environment.carby.navigation.Screens

@Composable
fun FoodQues(navController: NavController) {
    var selectedFrequency by remember { mutableStateOf("every week") }
    var selectedLaundry by remember { mutableStateOf("cold water") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        MCQQUes(
            qu = "How often do you eat healthy food?",
            op1 = "every week",
            op2 = "every month",
            op3 = "every year",
            selected = selectedFrequency,
            onSelect = { selectedFrequency = it }
        )

        MCQQUes(
            qu = "Do you prefer local food over healthy food?",
            op1 = "yes",
            op2 = "no",
            op3 = "sometimes",
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
                navController.navigate(Screens.FoodHomeScreen.route)
            }
        }
    }
}