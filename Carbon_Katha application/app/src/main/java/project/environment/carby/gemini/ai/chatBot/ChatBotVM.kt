package project.environment.carby.gemini.ai.chatBot

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import project.environment.carby.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch
import project.environment.carby.gemini.ai.imageBot.components.utils.ModelConstants

class ChatBotVM : ViewModel() {

    val list by lazy { mutableStateListOf<ChatData>() }

    private val generativeModel by lazy {
        GenerativeModel(
            modelName = ModelConstants.GEMINI_PRO,
            apiKey = BuildConfig.apikey
        )
    }


    fun sendMessage(message: String) = viewModelScope.launch {

        val chat = generativeModel.startChat(
            history = listOf(
                content(role = "user") { text("I am android developer") },
                content(role = "model") { text("Great. Need any help about android.") },
            )
        )

        list.add(ChatData(role = ChatRoleEnum.USER.role, message = message))

        chat.sendMessage(
            content(role = ChatRoleEnum.USER.role) { text(message) }
        ).text?.let {
            list.add(ChatData(role = ChatRoleEnum.MODEL.role, message = it))
        }
    }

}