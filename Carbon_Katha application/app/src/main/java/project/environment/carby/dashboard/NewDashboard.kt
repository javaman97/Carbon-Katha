//package project.environment.carby.dashboard
//
//import android.app.Activity
//import androidx.activity.compose.BackHandler
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Card
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.blur
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.StrokeCap
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import kotlinx.coroutines.delay
//import project.environment.carby.R
//import project.environment.carby.firebase.ProfileInfo
//import project.environment.carby.navigation.Screens
//import project.environment.carby.profile.profile.ProfileImage
//import project.environment.carby.ui.theme.CardColor
//import project.environment.carby.ui.theme.CardTextColor
//import project.environment.carby.ui.theme.appBackground
//import project.environment.carby.ui.theme.monteBold
//import project.environment.carby.ui.theme.monteNormal
//import project.environment.carby.ui.theme.monteSB
//import project.environment.carby.ui.theme.textColor
//import kotlin.system.exitProcess
//
//
//@Composable
//fun NewDashboard(
//    navController: NavHostController,
//    email: String,
//    name: String,
//    pfp: String
//) {
//    var profileList by remember {
//        mutableStateOf<List<ProfileInfo>?>(null)
//    }
//    var address by remember {
//        mutableStateOf("")
//    }
//    var animStart by remember {
//        mutableStateOf(false)
//    }
//    var phoneNumber by remember {
//        mutableStateOf("")
//    }
//    var gender by remember {
//        mutableStateOf("")
//    }
//
//
//    LaunchedEffect(key1 = viewModel.showLevelDialog) {
//        if (viewModel.showLevelDialog) {
//            animStart = true
//            delay(1000)
//            animStart = false
//        }
//    }
//    val activity = (LocalContext.current as? Activity)
//    BackHandler {
//        activity?.finishAndRemoveTask()
//        exitProcess(0)
//    }
//
//        JetFirestore(path = {
//            collection("ProfileInfo")
//        }, onRealtimeCollectionFetch = { value, _ ->
//            profileList = value?.getListOfObjects()
//        }) {
//            if (profileList != null) {
//                for (i in profileList!!) {
//                    if (i.email == email) {
//                        address = i.address ?: ""
//                        gender = i.gender ?: ""
//                        phoneNumber = i.phoneNumber ?: ""
//
//                    }
//                }
//            }
//
//            Box(modifier = Modifier.fillMaxSize()) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(appBackground)
//                        .verticalScroll(rememberScrollState())
//
//                ) {
//                    Card(
//                        modifier = Modifier
//                            .clip(RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp))
//                            .fillMaxWidth(),
//                        backgroundColor = CardColor,
//
//                        ) {
//                        Column {
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(
//                                        top = 45.dp,
//                                        bottom = 15.dp,
//                                        end = 25.dp,
//                                        start = 25.dp
//                                    ),
//                                horizontalArrangement = Arrangement.SpaceBetween,
//                                verticalAlignment = Alignment.CenterVertically
//                            ) {
//                                Column {
//                                    Text(
//                                        text = "Welcome Back",
//                                        color = Color.Gray,
//                                        fontSize = 13.sp,
//                                        fontFamily = monteSB,
//                                        modifier = Modifier.padding(bottom = 7.dp)
//                                    )
//                                    Text(
//                                        text = name,
//                                        color = CardTextColor,
//                                        fontSize = 20.sp,
//                                        fontFamily = monteBold,
//                                        modifier = Modifier.padding(bottom = 7.dp)
//                                    )
//                                    Text(
//                                        text = "Start making a difference today!",
//                                        color = Color.Gray,
//                                        fontSize = 13.sp,
//                                        fontFamily = monteSB,
//                                        modifier = Modifier.padding(bottom = 7.dp)
//                                    )
//                                }
//                                ProfileImage(
//                                    imageUrl = pfp,
//                                    modifier = Modifier
//                                        .size(70.dp)
//                                        .border(
//                                            width = 1.dp,
//                                            color = textColor,
//                                            shape = CircleShape
//                                        )
//                                        .padding(2.dp)
//                                        .clip(CircleShape)
//                                        .clickable {
//                                            navController.navigate(Screens.Profile.route)
//                                        }
//                                )
//                            }
//
//                        }
//                    }
//
//
//
//
//                        }
//
//                    }
//
//
//
//
//                }
//
//
//
//}
//
//@Composable
//fun ArcComposable(
//    modifier: Modifier,
//    text: String,
//    progress: Float = 0.5f, // Progress value between 0.0 and 1.0
//    completedColor: Color = Color(0xFF48c5a3),
//    remainingColor: Color = Color(0xFFe4e4e4),
//) {
//    val sweepAngle = 180f * progress
//    Box(
//        modifier = modifier.background(Color.Transparent)
//    ) {
//        Canvas(modifier = Modifier.size(70.dp)) {
//            // Draw the remaining part of the arc
//            drawArc(
//                color = remainingColor,
//                -180f + sweepAngle,
//                180f - sweepAngle,
//                useCenter = false,
//                size = Size(size.width, size.height),
//                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
//            )
//
//            // Draw the completed part of the arc
//            drawArc(
//                color = completedColor,
//                -180f,
//                sweepAngle,
//                useCenter = false,
//                size = Size(size.width, size.height),
//                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
//            )
//        }
//        Text(
//            modifier = Modifier.align(alignment = Alignment.Center),
//            text = text,
//            color = textColor,
//            fontSize = 20.sp
//        )
//    }
//}
