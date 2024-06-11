package com.hfad.pictures

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun ImageListScreen(viewModel: ImageViewModel) {
    val images by viewModel.images.collectAsState()
    ImageList(images = images)
}