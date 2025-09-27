package com.rl.socialnet.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rl.socialnet.R
import com.rl.socialnet.presentation.navigation.AppNavGraph
import com.rl.socialnet.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    val navController = rememberNavController()
    val currentBackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackEntry?.destination?.route

    val title = when(currentRoute) {
        Screen.SignUp.route -> stringResource(id = R.string.create_account)
        Screen.SignIn.route -> stringResource(id = R.string.sign_in)
        Screen.Home.route -> stringResource(id = R.string.app_name)
        else -> ""
    }


    Scaffold (
        topBar = {
            if (currentRoute != Screen.Welcome.route) {
                TopAppBar(
                    title = {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        if (currentRoute != Screen.Home.route) {
                            IconButton(
                                onClick = {
                                    navController.popBackStack()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = stringResource(id = R.string.back)
                                )
                            }
                        }
                    }
                )
            }
        }
    ){ innerPadding ->
        AppNavGraph(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            isAuthenticated = false
        )
    }
}