package project.environment.carby.gemini.ai.imageBot.components

import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import project.environment.carby.ui.theme.MainGreen

@Composable
fun ImageAndText(
    viewModel: ImageAndTextVM = viewModel(),
    navController: NavController
) {

    val context = LocalContext.current

    val pickImageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()){
        it?.let { uri ->
            val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ImageDecoder.decodeBitmap(
                    ImageDecoder.createSource(context.contentResolver ,uri)
                )
            } else {
                BitmapFactory.decodeFile(uri.path)
            }
            viewModel.imageList.add(bitmap)
        }
    }


   Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.fillMaxSize()
   ) {
       //Header
       ImageHeader()

       //Body
       Box(
           modifier = Modifier.weight(1f),
           contentAlignment = Alignment.Center
       ) {
          Column(modifier = Modifier.fillMaxSize().background(MainGreen)) {
              ImageTextBody(viewModel = viewModel)
          }
       }

       //Footer
       ImageFooter(
           list = viewModel.imageList,
           pickImageClick = {
               pickImageLauncher.launch(
                   PickVisualMediaRequest(
                       mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                   )
               )
           },
           submitClick = {
               viewModel.generateContentData(it)
           }
       )


       Spacer(modifier = Modifier.height(60.dp))
   }
}