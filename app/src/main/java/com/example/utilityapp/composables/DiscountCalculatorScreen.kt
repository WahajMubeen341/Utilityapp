package com.example.utilityapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.utilityapp.R
import com.example.utilityapp.ui.theme.UtilityAppTheme

@Composable
fun DiscountCalculatorScreen(navController: NavController) {
    var price by remember { mutableStateOf("") }
    var discount by remember { mutableStateOf("") }

    val finalPrice = price.toFloatOrNull()?.let { p ->
        discount.toFloatOrNull()?.let { d ->
            p - (p * d / 100)
        }
    }

        // Foreground Content
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Discount Calculator",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge
            )

            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Original Price") },
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = discount,
                onValueChange = { discount = it },
                label = { Text("Discount (%)") },
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            finalPrice?.let {
                Text("Final Price: ${"%.2f".format(it)}")
            }



            Spacer(modifier = Modifier.height(40.dp))


            // Background Vector Image
            Image(
                painter = painterResource(id = R.drawable.discount_2), // your vector drawable
                contentDescription = "Background",
                modifier = Modifier.align(Alignment.End)
                    .alpha(0.6f), // Optional: make it lighter so it doesn’t overpower text
                contentScale = ContentScale.Fit, // or ContentScale.Fit depending on your vector
            )

        }
}

@Preview(showBackground = true)
@Composable
fun DiscountCalculatorPreview() {
    UtilityAppTheme {
        DiscountCalculatorScreen(navController = rememberNavController())
    }
}
