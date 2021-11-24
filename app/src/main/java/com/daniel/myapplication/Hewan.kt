package com.daniel.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hewan(
    val id:Int,
    val title:String,
    val description:String,
    val image:Int,
):Parcelable