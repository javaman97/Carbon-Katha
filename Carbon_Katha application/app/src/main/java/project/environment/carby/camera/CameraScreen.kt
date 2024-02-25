//import android.content.Context
//import android.graphics.Bitmap
//import android.graphics.Matrix
//import android.util.Log
//import androidx.camera.core.CameraSelector
//import androidx.camera.core.ImageCapture
//import androidx.camera.core.ImageCaptureException
//import androidx.camera.core.ImageProxy
//import androidx.camera.view.CameraController
//import androidx.camera.view.LifecycleCameraController
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.BottomSheetScaffold
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.material.TextFieldDefaults
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.PlayArrow
//import androidx.compose.material.icons.filled.Send
//import androidx.compose.material.rememberBottomSheetScaffoldState
//import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.core.content.ContextCompat
//import kotlinx.coroutines.launch
//import project.environment.carby.camera.CameraPreview
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun CameraScreen(viewModel: MainViewModel, context: Context) {
//    val scope = rememberCoroutineScope()
//    val scaffoldState = rememberBottomSheetScaffoldState()
//    val controller = remember {
//        LifecycleCameraController(context).apply {
//            setEnabledUseCases(CameraController.IMAGE_CAPTURE, ImageCapture::class.java)
//        }
//    }
//
//    var text by remember { mutableStateOf("") }
//    var showPhotoScreen by remember { mutableStateOf(false) }
//    var capturedBitmap by rememberSaveable { mutableStateOf<Bitmap?>(null) }
//
//    fun showPhoto(bitmap: Bitmap, text: String) {
//        capturedBitmap = bitmap
//        this.text = text // Store the text
//        showPhotoScreen = true
//    }
//
//    BottomSheetScaffold(
//        scaffoldState = scaffoldState,
//        sheetPeekHeight = 0.dp,
//        sheetContent = {
//            // PhotoBottomSheetContent(
//            //     viewModel = viewModel,
//            //     modifier = Modifier.fillMaxWidth()
//            // )
//        }
//    ) { padding ->
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//        ) {
//            if (showPhotoScreen) {
//                capturedBitmap?.let { bitmap ->
//                    PhotoScreen(bitmap = bitmap, text = text) {
//                        showPhotoScreen = false
//                        scope.launch {
//                            scaffoldState.bottomSheetState.expand()
//                        }
//                    }
//                }
//            } else {
//                CameraPreview(
//                    controller = controller,
//                    modifier = Modifier.fillMaxSize()
//                )
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .align(Alignment.BottomCenter)
//                ) {
//                    Row(
//                        modifier = Modifier.padding(16.dp),
//                        horizontalArrangement = Arrangement.SpaceAround
//                    ) {
//                        IconButton(
//                            onClick = {
//                                scope.launch {
//                                    scaffoldState.bottomSheetState.expand()
//                                }
//                            }
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.PlayArrow,
//                                contentDescription = "Open gallery"
//                            )
//                        }
//
//                        BasicTextField(
//                            value = text,
//                            onValueChange = { newText ->
//                                text = newText
//                            },
//                            singleLine = true,
//                            modifier = Modifier.weight(1f).padding(horizontal = 8.dp),
//                        )
//
//                        IconButton(
//                            onClick = {
//                                // Capture image with message
//                                takePhoto(
//                                    controller = controller,
//                                    context = context,
//                                    text = text,
//                                    onPhotoTaken = { bitmap, text ->
//                                        showPhoto(bitmap, text)
//                                    }
//                                )
//                            }
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.PlayArrow,
//                                contentDescription = "Take photo"
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun takePhoto(
//    controller: LifecycleCameraController,
//    context: Context,
//    text: String,
//    onPhotoTaken: (Bitmap, String) -> Unit
//) {
//    controller.takePicture(
//        ContextCompat.getMainExecutor(context),
//        object : ImageCapture.OnImageCapturedCallback() {
//            override fun onCaptureSuccess(image: ImageProxy) {
//                super.onCaptureSuccess(image)
//
//                val matrix = Matrix().apply {
//                    postRotate(image.imageInfo.rotationDegrees.toFloat())
//                }
//                val rotatedBitmap = Bitmap.createBitmap(
//                    image.toBitmap(),
//                    0,
//                    0,
//                    image.width,
//                    image.height,
//                    matrix,
//                    true
//                )
//
//                onPhotoTaken(rotatedBitmap, text)
//            }
//
//            override fun onError(exception: ImageCaptureException) {
//                super.onError(exception)
//                Log.e("Camera", "Couldn't take photo: ", exception)
//            }
//        }
//    )
//}
//
//
//@Composable
//fun PhotoScreen(bitmap: Bitmap, text: String, onConfirm: () -> Unit) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Image(
//            bitmap = bitmap.asImageBitmap(),
//            contentDescription = null,
//            modifier = Modifier.fillMaxSize()
//        )
//
//        Text(
//            text = text,
//            color = Color.White,
//            fontSize = 24.sp,
//            modifier = Modifier
//                .padding(16.dp)
//                .align(Alignment.TopStart)
//        )
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .align(Alignment.BottomCenter)
//        ) {
//            var inputText by remember { mutableStateOf("") }
//            TextField(
//                value = inputText,
//                onValueChange = { inputText = it },
//                modifier = Modifier.weight(1f),
//                colors = TextFieldDefaults.textFieldColors(),
//                label = { Text("Type a message") },
//                singleLine = true,
//                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
//                keyboardActions = KeyboardActions(onSend = {
//                    viewModel.sendImgMessage(inputText)
//                    inputText = ""
//                })
//            )
//
//            IconButton(
//                onClick = {
//                    viewModel.sendMessage(inputText)
//                    inputText = ""
//                },
//                modifier = Modifier.padding(start = 8.dp)
//            ) {
//                Icon(
//                    Icons.Default.Send,
//                    contentDescription = "Send message"
//                )
//            }
//        }
//    }
//}
