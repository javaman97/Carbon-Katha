package project.environment.carby.navigation


import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import project.environment.carby.Communities
import project.environment.carby.Contribute
import project.environment.carby.MainHomeScreen
import project.environment.carby.fashion.FashionFeed
import project.environment.carby.fashion.FashionHomeScreen
import project.environment.carby.fashion.FashionQues
import project.environment.carby.fashion.FashionStart
import project.environment.carby.food.FoodAI
import project.environment.carby.food.FoodChatbot
import project.environment.carby.food.FoodEmission
import project.environment.carby.food.FoodHomeScreen
import project.environment.carby.food.FoodQues
import project.environment.carby.food.FoodRecipe
import project.environment.carby.food.FoodSearch
import project.environment.carby.food.FoodWasteDisposal
import project.environment.carby.food.FoodWasteDisposalTips
import project.environment.carby.food.GroceryList
import project.environment.carby.food.RecipeDetails
import project.environment.carby.food.RecipeDetailsAlternate

import project.environment.carby.gemini.ai.chatBot.ChatBot
import project.environment.carby.gemini.ai.imageBot.components.ImageAndText
import project.environment.carby.technology.Technology
import project.environment.carby.transport.TransportFlight
import project.environment.carby.transport.TransportHome
import project.environment.carby.transport.TransportJourney
import project.environment.carby.transport.TransportJourneyTime
import project.environment.carby.transport.TransportOptions

@Composable
fun MainNavController(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
//        startDestination = Screens.MainHomeScreen.route,
    ) {

        composable(
            Screens.MainHomeScreen.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            },
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            }
        ) {
            MainHomeScreen(navHostController = navController)
        }

        composable(Screens.FoodHomeScreen.route) {
            FoodHomeScreen(navController = navController)
        }
        composable(Screens.FoodSearch.route) {
            FoodSearch(navController = navController)
        }
        composable(Screens.FoodRecipe.route) {
            FoodRecipe(navController = navController)
        }
        composable(Screens.RecipeDetails.route) {
            RecipeDetails(navController = navController)
        }

        composable(Screens.FoodEmission.route) {
            FoodEmission(navController = navController)
        }
        composable(Screens.FoodQues.route) {
            FoodQues(navController = navController)
        }
//        composable(Screens.RecipeDetailsIngre.route) {
//            RecipeDetailsIngre(navController = navController)
//        }
//        composable(Screens.RecipeDetailsInstruct.route) {
//            RecipeDetailsInstruct(navController = navController)
//        }
        composable(Screens.RecipeDetailsAlternate.route) {
            RecipeDetailsAlternate(navController = navController)
        }
        composable(Screens.FoodWasteDisposal.route) {
            FoodWasteDisposal(navController = navController)
        }

        composable(Screens.FoodWasteDisposalTips.route) {
            FoodWasteDisposalTips(navController = navController)
        }

        composable(Screens.GroceryList.route) {
            GroceryList(navController = navController)
        }
        composable(Screens.FoodChatbot.route) {
            FoodChatbot(navController = navController)
        }
        composable(Screens.FoodAI.route) {
            FoodAI(navController = navController)
        }

        composable(Screens.FashionStart.route) {
            FashionStart(navController = navController)
        }
        composable(Screens.FashionQues.route) {
            FashionQues(navController = navController)
        }
        composable(Screens.FashionHomeScreen.route) {
            FashionHomeScreen(navController = navController)
        }
        composable(Screens.FashionFeed.route) {
            FashionFeed(navController = navController)
        }
        composable(Screens.Communities.route) {
            Communities(navController = navController)
        }

        composable(Screens.TransportHome.route) {
            TransportHome(navController = navController)
        }

        composable(Screens.TransportOptions.route) {
            TransportOptions(navController = navController)
        }
        composable(Screens.TransportJourney.route) {
           TransportJourney(navController = navController)
        }
        composable(Screens.TransportJourneyTime.route) {
            TransportJourneyTime(navController = navController)
        }
        composable(Screens.TransportFlight.route) {
           TransportFlight(navController = navController)
        }




        composable(Screens.ChatBot.route) {
            ChatBot(navController = navController)
        }
        composable(Screens.ImageAndText.route) {
            ImageAndText(navController = navController)
        }
        composable(Screens.Splash.route) {
            SplashScreen(navController = navController)
        }



        composable(Screens.Contribute.route) {
            Contribute(navController = navController)
        }

        composable(Screens.Technology.route) {
           Technology(navController = navController)
        }


//
//        composable(Screens.SignInScreen.route) {
//            SignInScreen(navController= navController)
//        }
    }
}
