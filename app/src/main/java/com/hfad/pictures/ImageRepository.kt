package com.hfad.pictures


class ImageRepository(private val imageDao: ImageDao) {
    fun getAllImages() = imageDao.getAllImages()

    fun insertImages(images: List<ImageEntity>) {
        imageDao.insertImages(images)
    }
}
