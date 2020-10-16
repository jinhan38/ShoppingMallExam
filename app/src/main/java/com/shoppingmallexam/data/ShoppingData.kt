package com.shoppingmallexam.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShoppingData(
    val title: String,
    val link: String,
    val description: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: Items

) : Parcelable {

    @Parcelize
    data class Items(
        val title: String,
        val link: String,
        val image: String,
        val lprice: Int,
        val hprice: Int,
        val mallName: String,
        val maker: String,
        val brand: String,
        val category1: String,
        val category2: String,
        val category3: String,
        val category4: String
    ) : Parcelable
}