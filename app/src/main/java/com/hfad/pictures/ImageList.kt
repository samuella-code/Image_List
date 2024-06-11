package com.hfad.pictures

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ImageList(images: List<ImageEntity>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Padding around the entire Column
    ) {
        Spacer(modifier = Modifier.height(24.dp)) // Add space at the top
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp), // Add space below the icons
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_circle_notifications_24),
                contentDescription = "Notification",
                modifier = Modifier
                    .size(44.dp)
                    .padding(9.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = "Human",
                modifier = Modifier
                    .size(44.dp)
                    .padding(9.dp)
            )
        }
        Text(
            text = "Store",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(bottom = 7.dp), // Adjust the space below the text as needed
            textAlign = TextAlign.Left // Align text to the left
        )
        LazyColumn {
            items(images) { image ->
                ImageItem(image = image)
            }
        }
        Footer(
            onFeedClick = { /* Handle feed click */ },
            onProgressClick = { /* Handle progress click */ },
            onCenterButtonClick = { /* Handle center button click */ },
            onStoreClick = { /* Handle store click */ },
            onMenuClick = { /* Handle menu click */ }
        )
    }
}

@Composable
fun ImageItem(image: ImageEntity) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center // Centers the text within the image
    ) {
        Image(
            painter = painterResource(id = image.imageRes),
            contentDescription = image.text,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)) // Apply rounded corners
        )
        Text(
            text = image.text,
            fontSize = 24.sp,
            color = Color.White, // Set the text color to white
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
    }
}