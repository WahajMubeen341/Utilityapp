package com.example.utilityapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.utilityapp.R

@Composable
fun BottomImage(painter: Painter){

        Image(
            painter = painter, // your vector drawable
            contentDescription = "Background",
            modifier = Modifier   //.align(Alignment.End)
                .alpha(0.6f), // Optional: make it lighter so it doesn’t overpower text
            contentScale = ContentScale.Fit, // or ContentScale.Fit depending on your vector
        )
}