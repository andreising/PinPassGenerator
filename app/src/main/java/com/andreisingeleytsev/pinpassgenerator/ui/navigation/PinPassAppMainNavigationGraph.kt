package com.andreisingeleytsev.pinpassgenerator.ui.navigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.pinpassgenerator.ui.screens.home_screen.HomeScreen
import com.andreisingeleytsev.pinpassgenerator.ui.screens.onboard_screen.OnBoardScreen
import com.andreisingeleytsev.pinpassgenerator.ui.screens.pass_screen.PassScreen
import com.andreisingeleytsev.pinpassgenerator.ui.screens.pin_screen.PinScreen
import com.andreisingeleytsev.pinpassgenerator.ui.utils.Routes


@Composable
fun PinPassAppMainNavigationGraph(
    navHostController: NavHostController, startDestination: String, onBoardFinished: () -> Unit
) {
    NavHost(
        navController = navHostController, startDestination = startDestination,
        modifier = Modifier.background(Color.Transparent)
    ) {
        composable(Routes.ONBOARDING_SCREEN) {
            OnBoardScreen(navHostController, onBoardFinished)
        }
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navHostController)
        }
        composable(Routes.PIN_SCREEN) {
            PinScreen(navHostController)
        }
        composable(Routes.PASS_SCREEN) {
            PassScreen()
        }
    }
}
