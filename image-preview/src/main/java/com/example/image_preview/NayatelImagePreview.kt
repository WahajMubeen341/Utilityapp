package com.example.image_preview


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImagePreview(
    modifier: Modifier = Modifier,
    imageRes: Int? = null,
    imageUrl: String? = null,
    cornerRadius: Int = 8,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius.dp))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        when {
            imageRes != null -> {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = contentDescription,
                    modifier = Modifier.matchParentSize(),
                    contentScale = contentScale
                )
            }
            imageUrl != null -> {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = contentDescription,
                    modifier = Modifier.matchParentSize(),
                    contentScale = contentScale
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreviewSample() {
    ImagePreview(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.77f)
            .padding(16.dp),
        imageUrl = "https://picsum.photos/600/400"
    )
}
