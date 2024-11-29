package com.aibatech.farmersmarketforsellers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aibatech.farmersmarketforsellers.ui.onboarding.OnboardingScreen
import com.aibatech.farmersmarketforsellers.ui.theme.FarmersMarketForSellersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarmersMarketForSellersTheme {
                // Remember the NavController
                val navController = rememberNavController()

                // Set up navigation graph
                NavHost(navController = navController, startDestination = "onboarding") {
                    // Define composables for each screen
                    composable("onboarding") {
                        OnboardingScreen(navController)
                    }
                    composable("login") {
                        // Placeholder for login screen (you'll define this screen later)
                        // LoginScreen(navController)
                    }
                    // Add more composable screens as needed (product management, profile, etc.)
                }
            }
        }
    }
}

