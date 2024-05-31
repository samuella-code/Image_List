package com.hfad.pictures

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ImageList(images: List<ImageEntity>) {
    LazyColumn {
        items(images.size) { index ->
            val image = images[index]
            ImageItem(image = image)
        }
    }
}
@Composable
fun ImageItem(image: ImageEntity) {
    Box(modifier = androidx.compose.ui.Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = image.imageRes),
            contentDescription = image.text,
            contentScale = ContentScale.Crop,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
        Text(
            text = image.text,
            fontSize = 24.sp,
            modifier = androidx.compose.ui.Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
    }
}