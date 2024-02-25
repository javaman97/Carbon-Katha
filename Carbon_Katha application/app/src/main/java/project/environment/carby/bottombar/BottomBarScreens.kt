package project.environment.carby.bottombar

import project.environment.carby.R
import project.environment.carby.navigation.Screens


sealed class BottomBarScreens(val route: String?, val title: String?, val icon: Int) {


     object Home : BottomBarScreens(
        Screens.MainHomeScreen.route,
        "Home",
        R.drawable.b1home
    )
    object Community : BottomBarScreens(
        Screens.Communities.route,
        "Community",
        R.drawable.b2community
    )
    object MainNav: BottomBarScreens(
        Screens.MainHomeScreen.route,
        "Home",
        R.drawable.categories
    )

    object Contribute : BottomBarScreens(
        Screens.Contribute.route,
        "Contribute",
        R.drawable.b4contribute
    )
    object Profile : BottomBarScreens(
        Screens.MainHomeScreen.route,
        "Profile",
        R.drawable.userimg
    )

}

val items = listOf(
    BottomBarScreens.Home,
    BottomBarScreens.Community,
    BottomBarScreens.MainNav,
    BottomBarScreens.Contribute,
    BottomBarScreens.Profile,

)