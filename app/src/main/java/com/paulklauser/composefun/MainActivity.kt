package com.paulklauser.composefun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            // Remember a SystemUiController
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = !isSystemInDarkTheme()

            DisposableEffect(systemUiController, useDarkIcons) {
                // Update all of the system bar colors to be transparent, and use
                // dark icons if we're in light theme
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = useDarkIcons
                )

                // setStatusBarColor() and setNavigationBarColor() also exist

                onDispose {}
            }

            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "Main") {
                composable("Main") {
                    // Scopes this ViewModel to this navigation destination
                    MainScreen(mainViewModel = koinViewModel(), onRowClicked = {
                        navController.navigate("Detail")
                    })
                }
                composable("Detail") {
                    DetailScreen(
                        // It's really nice that you can pass parameters to the ViewModel injector
                        viewModel = koinViewModel(parameters = { parametersOf("1") }),
                        goBack = {
                            navController.popBackStack()
                        })
                }
            }
        }
    }
}