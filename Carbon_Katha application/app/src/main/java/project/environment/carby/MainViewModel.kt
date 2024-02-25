import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    data class ImgMessage(val content: String, val role: String)

    val imgMessages = mutableStateListOf<ImgMessage>()

    private val _bitmaps = MutableStateFlow<List<Bitmap>>(emptyList())
    val bitmaps = _bitmaps.asStateFlow()

    fun onTakePhoto(bitmap: Bitmap, text: String) {
        imgMessages.add(ImgMessage(content = text, role = "user"))
        _bitmaps.value += bitmap
    }

    // Other functions...

}
