package com.example.utilityapp.composables

import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.image_preview.ImagePreview
import com.example.utilityapp.R
import com.example.utilityapp.ui.theme.Background
import com.example.utilityapp.ui.theme.Primary
import com.example.utilityapp.ui.theme.Secondary
import com.example.utilityapp.ui.theme.Surface
import com.example.utilityapp.ui.theme.UtilityAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {



    LaunchedEffect(Unit) {
//        Log.d("utility_app", "navController graph = ${navController.graph}")
//        Log.d("utility_app", "navController current destination = ${navController.currentDestination}")
    }

    val utilities = listOf(
        "Discount Calculator" to "discount",
        "Unit Converter" to "units_converter",
        "Power Converter" to "power",
        "Test" to "test"
    )

    val utilityPairs = utilities.chunked(2)

    Column(modifier = Modifier.fillMaxSize().background(Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        ImagePreview(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .padding(8.dp),
            imageUrl = "https://picsum.photos/500/300"
        )

        Text(
            "Features",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {
            items(utilityPairs) { pair ->
                Row(
                    modifier = Modifier.fillParentMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)

                ) {

                    pair.forEach {(title, route) ->

                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(140.dp)
                                .padding(0.dp, 8.dp, 0.dp, 8.dp)
                                .clickable {
                                    Log.e("utility_app", "nav controller = $navController")
                                    navController.navigate(route)
                                           },
                            colors = CardDefaults.cardColors(
                                containerColor = Surface,
                                contentColor = MaterialTheme.colorScheme.onSurface,

                            ),
//                            elevation = CardDefaults.cardElevation(1.dp),
//                            border = BorderStroke(0.dp, Primary)
                        )
                        {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.discount_new),
                                    contentDescription = "Icon",
                                    modifier = Modifier
                                        .size(70.dp)
                                        .padding(vertical = 8.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 4.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = title,
                                        color = MaterialTheme.colorScheme.primary,
                                        style = MaterialTheme.typography.titleMedium,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                            }
                        }

                    }
                }
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 8.dp)
//                            .clickable { navController.navigate(route) },
//                        elevation = CardDefaults.cardElevation(8.dp),
//                        border = BorderStroke(
//                            1.dp,
//                            MaterialTheme.colorScheme.primary
//                        ) // or any color
//
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .padding(16.dp)
//                                .fillParentMaxWidth(),
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//
//                            Image(
//                                painter = painterResource(id = R.drawable.ic_discout), // your vector drawable
//                                contentDescription = "Background",
//                                modifier = Modifier
//                                    .align(Alignment.CenterHorizontally)
//                                    .size(100.dp)
//                                    .padding(0.dp, 8.dp, 0.dp, 8.dp)
//                                    .alpha(1f), // Optional: make it lighter so it doesn’t overpower text
//                                contentScale = ContentScale.Fit, // or ContentScale.Fit depending on your vector
//                            )
//
//                            Text(
//                                title,
//                                color = MaterialTheme.colorScheme.primary,
//                                style = MaterialTheme.typography.titleMedium
//                            )
//                        }
//                    }
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 8.dp)
//                            .clickable { navController.navigate(route) },
//                        elevation = CardDefaults.cardElevation(8.dp),
//                        border = BorderStroke(
//                            1.dp,
//                            MaterialTheme.colorScheme.primary
//                        ) // or any color
//
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .padding(16.dp)
//                                .fillParentMaxWidth(),
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//
//                            Image(
//                                painter = painterResource(id = R.drawable.ic_discout), // your vector drawable
//                                contentDescription = "Background",
//                                modifier = Modifier
//                                    .align(Alignment.CenterHorizontally)
//                                    .size(100.dp)
//                                    .padding(0.dp, 8.dp, 0.dp, 8.dp)
//                                    .alpha(1f), // Optional: make it lighter so it doesn’t overpower text
//                                contentScale = ContentScale.Fit, // or ContentScale.Fit depending on your vector
//                            )
//
//                            Text(
//                                title,
//                                color = MaterialTheme.colorScheme.primary,
//                                style = MaterialTheme.typography.titleMedium
//                            )
//                        }
//                    }
//                }


            }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    UtilityAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NestedScroller(){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Column {
                        Text("Wahaj Mubeen", style = MaterialTheme.typography.titleLarge)
                        Text("Assistant Manager", style = MaterialTheme.typography.bodyMedium)
                    }
                },
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    // Profile avatar or back button
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Person, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(30) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(120.dp)
                ) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Item $it")
                    }
                }
            }
        }
    }
}

