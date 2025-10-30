package com.example.utilityapp.composables

import ads_mobile_sdk.h6
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.utilityapp.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import com.example.utilityapp.components.BottomImage
import com.example.utilityapp.components.DropdownMenuSelector
import com.example.utilityapp.components.ScreenTitle


@Composable
fun UnitsConverterScreen(navController: NavHostController) {
    var inputValue by remember { mutableStateOf("") }
    var fromUnit by remember { mutableStateOf("Meter") }
    var toUnit by remember { mutableStateOf("Kilometer") }
    var result by remember { mutableStateOf("") }

    val units = listOf("Meter", "Kilometer", "Centimeter")

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .padding(16.dp)
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally    ) {
        ScreenTitle(stringResource(id = R.string.unit_converter))

//        Card(
//            modifier = Modifier.fillMaxWidth()
//                .padding(16.dp),
//            shape = RoundedCornerShape(16.dp),
//            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
//            colors = CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.surface,
//                contentColor = MaterialTheme.colorScheme.onSurface
//
//        )) {

        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = { Text(stringResource(id = R.string.enter_value)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            DropdownMenuSelector("From", fromUnit, units) { fromUnit = it }
            Spacer(Modifier.width(16.dp))
            DropdownMenuSelector("To", toUnit, units) { toUnit = it }
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            val value = inputValue.toDoubleOrNull() ?: 0.0
            result = convertUnit(value, fromUnit, toUnit)
        }) {
            Text("Convert")
        }

        Spacer(Modifier.height(16.dp))
        Text("Result: $result")

        BottomImage(painterResource(id = R.drawable.discount_2))
    }
//    }
}

fun convertUnit(value: Double, from: String, to: String): String {
    val meters = when (from) {
        "Meter" -> value
        "Kilometer" -> value * 1000
        "Centimeter" -> value / 100
        else -> value
    }

    val converted = when (to) {
        "Meter" -> meters
        "Kilometer" -> meters / 1000
        "Centimeter" -> meters * 100
        else -> meters
    }

    return "%.3f".format(converted)
}


//@Composable
//fun UnitsConverterScreen(navController: NavHostController) {
//    val utilities = listOf(
//        "Weights" to "weight",
//        "Power" to "power",
//        "Distance" to "distance",
//        "Test" to "test"
//    )
//
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        contentPadding = PaddingValues(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        items(utilities) { (title, route) ->
//            UtilityCard(title = title, route = route, navController = navController)
//        }
//    }
//}
//
//@Composable
//fun UtilityCard(title: String, route: String, navController: NavController) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .aspectRatio(1f)
//            .clickable { navController.navigate(route) },
//        elevation = CardDefaults.cardElevation(8.dp),
//        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_discout),
//                contentDescription = "Icon",
//                modifier = Modifier
//                    .size(64.dp)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = title,
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.primary,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//    }
//}