package com.shoppingmallexam.api

import com.shoppingmallexam.data.ShoppingData

data class ShoppingResponse(
    val results: List<ShoppingData>
)