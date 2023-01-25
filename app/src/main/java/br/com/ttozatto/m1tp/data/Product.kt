package br.com.ttozatto.m1tp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(val Name: String,
    val Quantity: Int) : Parcelable
