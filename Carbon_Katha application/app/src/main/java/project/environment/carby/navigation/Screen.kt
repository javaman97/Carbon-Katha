package project.environment.carby.navigation

sealed class Screens(val route: String) {

     object MainHomeScreen : Screens("MainHome")

     object FoodHomeScreen : Screens("FoodHome")
     object FoodSearch : Screens("FoodSearch")
     object FoodRecipe : Screens("FoodRecipe")
     object RecipeDetails : Screens("RecipeDetails")
     object RecipeDetailsAlternate : Screens("RecipeDetails")
     object RecipeDetailsIngre : Screens("RecipeDetailsIngre")
     object RecipeDetailsInstruct : Screens("RecipeDetailsInstruct")
     object FoodWasteDisposal : Screens("FoodWasteDisposal")
     object FoodWasteDisposalTips : Screens("FoodWasteDisposal")
     object GroceryList : Screens("GroceryList")
     object FoodChatbot : Screens("FoodChatbot")
     object FoodAI : Screens("FoodAI")
     object FoodEmission : Screens("emission")
     object FoodQues : Screens("ques")

     object FashionStart : Screens("FashionStart")
     object FashionQues : Screens("FashionQues")
     object FashionHomeScreen : Screens("FashionHomeScreen")
     object FashionFeed : Screens("FashionFeed")
     object Communities : Screens("Communities")


     object TransportJourney : Screens("Transportjourney")
     object TransportJourneyTime : Screens("Transporttime")
     object TransportFlight : Screens("Transportflight")
     object TransportHome : Screens("TransportHome")
     object TransportOptions : Screens("TransportOptions")

     object Technology : Screens("image")


     object ProfileScreen : Screens("profile")
     object Splash : Screens("splash")
     object Onboarding : Screens("onboarding")
     object Contribute : Screens("contri")
     object ChatBot : Screens("bot")
     object ImageAndText : Screens("image")


     object  SignInScreen : Screens("si")
}
