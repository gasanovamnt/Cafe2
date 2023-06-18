package com.example.cafe

data class GoodModel(
    val name: String,
    val price: Int,
    val url: String,
    var count: Int = 0
)