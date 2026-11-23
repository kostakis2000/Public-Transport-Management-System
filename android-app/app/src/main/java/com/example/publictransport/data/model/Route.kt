package com.example.publictransport.data.model

data class Route(
    val id: Int,
    val name: String,
    val destination: String,
    val fare: Double,
    val totalSeats: Int
)
