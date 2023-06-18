package com.example.cafe

data class FeaturedModel(
    val name: String,
    val amount: String,
    val level: String,
    var loved: String,
    val url: String,
    var count: Int = 0
)