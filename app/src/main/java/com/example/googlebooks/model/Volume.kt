package com.example.googlebooks.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

//Using data class to store the data from the request because it's gives an immense amount of self-generated code.
@Parcelize
data class Volume(
    val id: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
): Parcelable
