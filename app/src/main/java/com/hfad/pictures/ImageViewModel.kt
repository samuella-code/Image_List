package com.hfad.pictures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageViewModel(private val repository: ImageRepository) : ViewModel() {


    val images = mutableListOf<ImageEntity>()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dbImages = repository.getAllImages()
                if (dbImages.isEmpty()) {
                    val newImages = listOf(
                        ImageEntity(1, R.drawable.image1, "Text 1"),
                        ImageEntity(2, R.drawable.image2, "Text 2"),
                        ImageEntity(3, R.drawable.image3, "Text 3"),
                        ImageEntity(4, R.drawable.image4, "Text 4"),
                        ImageEntity(5, R.drawable.image5, "Text 5"),
                        ImageEntity(6, R.drawable.image6, "Text 6"),
                        ImageEntity(7, R.drawable.image7, "Text 7"),
                        ImageEntity(8, R.drawable.image8, "Text 8"),
                        ImageEntity(9, R.drawable.image, "Text 9"),
                    )
                    repository.insertImages(newImages)
                    images.addAll(newImages)
                } else {
                    images.addAll(dbImages)
                }
            }
        }
    }
}