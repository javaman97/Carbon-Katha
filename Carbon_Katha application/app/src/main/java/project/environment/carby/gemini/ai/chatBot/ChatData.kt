package project.environment.carby.gemini.ai.chatBot

data class ChatData(
    val role: String,
    val message: String
)


enum class ChatRoleEnum(val role: String) {
    USER("user"),
    MODEL("model")
}
