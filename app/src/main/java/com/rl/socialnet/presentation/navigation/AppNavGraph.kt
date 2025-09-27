package com.rl.socialnet.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rl.socialnet.presentation.screen.home.HomeScreen
import com.rl.socialnet.presentation.screen.signin.SignInScreen
import com.rl.socialnet.presentation.screen.signup.SignUpScreen
import com.rl.socialnet.presentation.screen.welcome.WelcomeScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    isAuthenticated: Boolean
) {

    NavHost(
        navController = navController,
        startDestination = if (isAuthenticated) Screen.Home.route else Screen.Welcome.route
    ) {
        composable(
            route = Screen.Welcome.route
        ) {
            WelcomeScreen(
                modifier = modifier
            )
        }

        composable(
            route = Screen.SignUp.route
        ) {
            SignUpScreen(
                modifier = modifier
            )
        }

        composable(
            route = Screen.SignIn.route
        ) {
            SignInScreen(
                modifier = modifier
            )
        }

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(
                modifier = modifier
            )
        }
    }
}