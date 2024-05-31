package com.hfad.pictures

import android.content.Context
import androidx.room.Room

class ImageRepository(context: Context) {
    private val db = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "image-database"
    ).build()

    private val imageDao = db.imageDao()

    fun getAllImages(): List<ImageEntity> = imageDao.getAllImages()

    fun insertImages(images: List<ImageEntity>) {
        imageDao.insertImages(images)
    }
}