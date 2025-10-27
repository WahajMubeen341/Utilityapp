package com.example.utilityapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.utilityapp.composables.DiscountCalculatorScreen
import com.example.utilityapp.composables.HomeScreen
import com.example.utilityapp.composables.SplashScreen
import com.example.utilityapp.composables.UnitsConverterScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("discount") {DiscountCalculatorScreen(navController)}
        composable("units_converter") {UnitsConverterScreen(navController)}
    }
}
