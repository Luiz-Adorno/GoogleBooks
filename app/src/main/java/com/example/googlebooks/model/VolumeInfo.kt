package com.example.googlebooks.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//Using data class to store the data from the request because it's gives an immense amount of self-generated code.
@Parcelize
data class VolumeInfo(
    val title: String,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishedData: String?,
    val pageCount: Int?,
    val imageLinks: ImageLinks?
):Parcelable
