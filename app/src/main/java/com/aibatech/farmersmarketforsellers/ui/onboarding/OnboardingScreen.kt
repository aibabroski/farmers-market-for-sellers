package com.aibatech.farmersmarketforsellers.ui.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aibatech.farmersmarketforsellers.ui.theme.FarmersMarketForSellersTheme

@Composable
fun OnboardingScreen(navController: NavController) {
    // Here you can replace with actual content from the design
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Onboarding Title
        Text(
            text = "Welcome to Farmer's Market",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Onboarding Image (You can use Coil for image loading if required)
        // Image(painter = painterResource(id = R.drawable.onboarding_image), contentDescription = "Onboarding")

        // Description
        Text(
            text = "Connect with local farmers and grow your business.",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        // Next Button
        Button(
            onClick = { navController.navigate("login") }, // Navigate to the login screen
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Started")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FarmersMarketForSellersTheme{
        OnboardingScreen(rememberNavController())
    }
}