package project.environment.carby.gemini.ai.chatBot

sealed interface ChatBotUiState {

    object Ideal : ChatBotUiState

    object Loading: ChatBotUiState

    data class Success(val chatData: String): ChatBotUiState

    data class Error(val chatError: String): ChatBotUiState
}