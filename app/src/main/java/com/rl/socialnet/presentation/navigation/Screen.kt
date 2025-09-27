package com.rl.socialnet.presentation.navigation

sealed class Screen(val route: String) {
    object Welcome: Screen(route = "welcome")
    object SignUp: Screen(route = "sign-up")
    object SignIn: Screen(route = "sign-in")
    object Home: Screen(route = "home")
}