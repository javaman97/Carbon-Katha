package project.environment.carby

import BottomBar
import MainViewModel
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.BottomDrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberBottomDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.auth.api.phone.SmsRetriever
import project.environment.carby.food.FoodWasteDisposal
import project.environment.carby.gemini.ai.chatBot.ChatBot
import project.environment.carby.gemini.ai.imageBot.components.ImageAndText
import project.environment.carby.navigation.MainNavController
import project.environment.carby.navigation.Screens
import project.environment.carby.permissions.PermissionDrawer
import project.environment.carby.technology.Technology
import project.environment.carby.transport.TransportFlight
import project.environment.carby.transport.TransportJourney
import project.environment.carby.transport.TransportJourneyTime
import project.environment.carby.ui.theme.CarbyTheme


@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()


    @OptIn(
        ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class,
        ExperimentalPermissionsApi::class, ExperimentalPermissionsApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(
                this, CAMERAX_PERMISSIONS, 0
            )
        }

        // Hide the status bar
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = Color.Transparent.hashCode()

        setContent {
            CarbyTheme {


                val navController = rememberNavController()
                val permissionState = rememberMultiplePermissionsState(
                    permissions = listOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.CAMERA,
                    )
                )
                val permissionDrawerState = rememberBottomDrawerState(
                    if (permissionState.allPermissionsGranted) BottomDrawerValue.Closed else BottomDrawerValue.Open
                )

                val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                when (navBackStackEntry?.destination?.route) {
                    Screens.MainHomeScreen.route -> {
                        bottomBarState.value = true
                    }

                    Screens.FoodHomeScreen.route -> {
                        bottomBarState.value = true
                    }

                    Screens.FoodRecipe.route -> {
                        bottomBarState.value = true
                    }

                    Screens.FoodSearch.route -> {
                        bottomBarState.value = true
                    }

                    Screens.ChatBot.route -> {
                        bottomBarState.value = false
                    }

                    Screens.ImageAndText.route -> {
                        bottomBarState.value = false
                    }


                    else -> {
                        bottomBarState.value = false
                    }
                }
                PermissionDrawer(
                    drawerState = permissionDrawerState,
                    permissionState = permissionState,
                    rationaleText = "To continue, allow Report Waste2Wealth to access your device's location" +
                            ". Tap Settings > Permission, and turn \"Access Location On\" on.",
                    withoutRationaleText = "Location permission required for functionality of this app." +
                            " Please grant the permission.",
                ) {
                    Scaffold(bottomBar = {
                        BottomBar(
                            navController = navController,
                            bottomBarState = bottomBarState
                        )
                    }) {

                        val scaffoldState = rememberScaffoldState()
                        val client = SmsRetriever.getClient(this)
                        client.startSmsUserConsent(null)
                        println(it)
//
                        MainNavController(
                            scaffoldState,
                            navController
                        )


//                        Communities(navController)

                    }

                }
            }

        }
    }


    private fun hasRequiredPermissions(): Boolean {
        return CAMERAX_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                applicationContext,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    companion object {
        private val CAMERAX_PERMISSIONS = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
        )
    }
}
