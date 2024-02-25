//package project.environment.carby.chatbot
//
//import androidx.compose.runtime.snapshots.SnapshotStateList
//import retrofit2.http.Body
//import retrofit2.http.Headers
//import retrofit2.http.POST
//
//interface OpenAIApi {
//    @Headers("Content-Type: application/json", "Authorization: Bearer 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")
//    @POST("v1/chat/completions")
//    suspend fun generateResponse(@Body requestBody: OpenAIRequestBody): OpenAIResponse
//}
//
//data class OpenAIRequestBody(
//    val model: String = "gpt-3.5-turbo",
//    val messages: SnapshotStateList<String>,
//    val max_tokens: Int = 50,
//    val n: Int = 1,
//    val temperature: Double = 1.0
//)
//
//data class OpenAIResponse(
//    val choices: List<MessageResponse>
//)
//
//data class MessageResponse(
//    val message: Message
//)