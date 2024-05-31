package com.hfad.pictures

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey val id: Int,
    val imageRes: Int,
    val text: String
)