package project.environment.carby.gemini.ai.imageBot.components

import android.graphics.Bitmap
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import project.environment.carby.ui.theme.MainGreen
import project.environment.carby.ui.theme.NeonYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageFooter(
    list: MutableList<Bitmap>? = null,
    pickImageClick: () -> Unit = {},
    submitClick: (text: String) -> Unit = {}
) {

    var inputText by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(NeonYellow)
                .padding(vertical = 10.dp)
        ) {


            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "Camera",
                    modifier = Modifier
                        .size(40.dp),
                    tint = MainGreen
                )
            }

            IconButton(onClick = { pickImageClick() }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier
                        .size(40.dp),
                    tint = MainGreen
                )

            }

            Card (modifier = Modifier.width(210.dp)){
                Row (modifier = Modifier.fillMaxWidth().padding(all = 15.dp)){
                    TextField(
                        value = inputText,
                        onValueChange = {
                            inputText = it
                        },
                        placeholder = {
                            Text(text = "Enter Your Question")
                        },
                        singleLine = true,
                        modifier = Modifier
                            .weight(1f)
                            .background(MainGreen).fillMaxWidth(),
                        maxLines = Int.MAX_VALUE // Allow multiple lines
                    )
                }
            }

            //Button Icon
            IconButton(onClick = {
                submitClick(inputText)
                inputText = ""
            }) {
                Icon(
                    Icons.Default.Send,
                    contentDescription = "Send",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(MainGreen)
                        .padding(8.dp),
                    tint = Color.White
                )
            }
        }

        val data = list ?: emptyList()

        AnimatedVisibility(visible = data.isNotEmpty()) {
            Spacer(modifier = Modifier.size(10.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ){
                items(list ?: emptyList()){
                    Box(modifier = Modifier
                        .size(50.dp)
                        .padding(5.dp)
                    ){
                        Image(
                            it.asImageBitmap(),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(55.dp))
        }
    }
}

@Preview
@Composable
fun ImageFooterPreview() {
    ImageFooter()
}