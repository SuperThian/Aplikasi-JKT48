package com.example.jkt48

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Idol(
    val name: String,
    val description: String,
    val photo: Int,
    val information: String,
    val jiko: String
) : Parcelable