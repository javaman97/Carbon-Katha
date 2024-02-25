package project.environment.carby.gemini.ai.chatBot

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import project.environment.carby.gemini.ai.chatBot.componentes.ChatFooter
import project.environment.carby.gemini.ai.chatBot.componentes.ChatHeader
import project.environment.carby.gemini.ai.chatBot.componentes.ChatListComponent
import project.environment.carby.navigation.Screens
import project.environment.carby.ui.theme.GreenLight
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow

@Composable
fun ChatBot(
    viewModel: ChatBotVM = viewModel(),
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MainGreen)
        ) {
            //Header
            ChatHeader()

            //Chat List
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                if (viewModel.list.isNotEmpty()) {
                    ChatListComponent(
                        list = viewModel.list
                    )
                } else {
                    Text(text = "Start Chat", color = GreenLight)
                }


                Card(
                    modifier = Modifier
                        .clickable { navController.navigate(Screens.ImageAndText.route) }
                        .align(Alignment.BottomEnd)
                        .padding(start = 287.dp, bottom = 12.dp)
                        .size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = "",
                        tint = MainGreen,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = NeonYellow)
                    )
                }

            }

            //Footer
            ChatFooter {
                if (it.isNotEmpty()) {
                    viewModel.sendMessage(it)
                }
            }
        }
    }
}