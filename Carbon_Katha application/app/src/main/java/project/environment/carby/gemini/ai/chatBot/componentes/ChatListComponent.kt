package project.environment.carby.gemini.ai.chatBot.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import project.environment.carby.gemini.ai.chatBot.ChatData
import project.environment.carby.gemini.ai.chatBot.ChatRoleEnum
import project.environment.carby.ui.theme.GreenLight
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow

@Composable
fun ChatListComponent(
    list: MutableList<ChatData>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        items(list){
            if (it.role == ChatRoleEnum.USER.role){
                Row (modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp).padding(start = 25.dp)) {
                    Row (modifier = Modifier.fillMaxSize().background(GreenLight)){
                        UserChatMessage(message = it.message)
                    }

                }
            } else {
                Row (modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp).padding(end = 25.dp)) {
                    Row(modifier = Modifier.fillMaxSize().background(GreenLight)) {
                        ModelChatMessage(message = it.message)
                    }
                }
            }
        }
    }
}

@Composable
fun UserChatMessage(
    message: String
) {

    Row (modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
        ){
        Text(
            text = message,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenLight)
                .padding(8.dp)
        )
    }
}

@Composable
fun ModelChatMessage(
    message: String
){
    Row (modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)){
        Text(
            text = message,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenLight)
                .padding(8.dp)
        )
    }
}