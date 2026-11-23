package com.example.publictransport.data.model

data class Booking(
    val passengerName: String,
    val routeName: String,
    val seatNumber: Int,
    val fare: Double
)
