package com.example.googlebooks.model

//Using data class to store the data from the request because it's gives an immense amount of self-generated code.
data class Volume(
    val id: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)
