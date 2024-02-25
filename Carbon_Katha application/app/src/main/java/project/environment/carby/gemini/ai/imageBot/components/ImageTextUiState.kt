package project.environment.carby.gemini.ai.imageBot.components

sealed interface ImageTextUiState {

    object Ideal : ImageTextUiState

    object Loading: ImageTextUiState

    data class Success(val data: String): ImageTextUiState

    data class Error(val error: String): ImageTextUiState

}