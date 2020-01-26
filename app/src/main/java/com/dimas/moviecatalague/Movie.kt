package com.dimas.moviecatalague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var name: String,
    var date: String,
    var description: String,
    var photo: Int
) : Parcelable