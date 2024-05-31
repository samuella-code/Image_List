package com.hfad.pictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hfad.pictures.ui.theme.PicturesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = ImageRepository(applicationContext)
        setContent {

            //row is horizontal and column is vertical
            //flutter.dev/learn

            PicturesTheme {
                val viewModel: ImageViewModel = viewModel(
                    factory = ImageViewModelFactory(repository)
                )
                ImageList(images = viewModel.images)
            }
        }
    }
}
