package com.hfad.pictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.hfad.pictures.ui.theme.PicturesTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : ComponentActivity() {

    private lateinit var repository: ImageRepository
    private val viewModel: ImageViewModel by viewModels { ImageViewModelFactory(repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "image-database"
        ).build()
        repository = ImageRepository(db.imageDao())

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                if (repository.getAllImages().isEmpty()) {
                    val initialImages = listOf(
                        ImageEntity(1, R.drawable.image1, "Text 1"),
                        ImageEntity(2, R.drawable.image2, "Text 2"),
                        ImageEntity(3, R.drawable.image3, "Text 3"),
                        ImageEntity(4, R.drawable.image4, "Text 4"),
                        ImageEntity(5, R.drawable.image5, "Text 5"),
                        ImageEntity(6, R.drawable.image6, "Text 6"),
                        ImageEntity(7, R.drawable.image7, "Text 7"),
                        ImageEntity(8, R.drawable.image8, "Text 8")
                    )
                    repository.insertImages(initialImages)
                }
            }
        }

        setContent {
            PicturesTheme {
                ImageListScreen(viewModel)
            }
        }
    }
}

            //row is horizontal and column is vertical  
            //flutter.dev/learn

