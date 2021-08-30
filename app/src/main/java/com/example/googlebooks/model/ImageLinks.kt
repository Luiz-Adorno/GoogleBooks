package com.example.googlebooks.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//Using data class to store the data from the request because it's gives an immense amount of self-generated code.
@Parcelize
data class ImageLinks(
    val smallThumbnail: String?,
    val thumbnail: String?
):Parcelable
