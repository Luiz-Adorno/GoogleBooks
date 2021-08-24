package com.example.googlebooks.model

//Using data class to store the data from the request because it's gives an immense amount of self-generated code.
data class VolumeInfo(
    val title: String,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishedData: String?,
    val pageCount: Int?,
    val imageLinks: ImageLinks?
)
