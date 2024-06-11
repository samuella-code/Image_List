package com.hfad.pictures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageViewModel(private val repository: ImageRepository) : ViewModel() {

    private val _images = MutableStateFlow<List<ImageEntity>>(emptyList())
    val images: StateFlow<List<ImageEntity>> get() = _images

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val dbImages = repository.getAllImages()
            _images.value = dbImages
        }
    }
}




