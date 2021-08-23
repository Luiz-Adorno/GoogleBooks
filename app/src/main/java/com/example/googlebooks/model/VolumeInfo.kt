package com.example.googlebooks.model

data class VolumeInfo(
    val title: String,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishedData: String?,
    val pageCount: Int?,
    val imageLinks: ImageLinks?
)