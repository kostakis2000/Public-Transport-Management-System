package com.example.publictransport.ui.booking

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.publictransport.R
import com.example.publictransport.data.model.Booking
import com.example.publictransport.data.repository.TransportRepository

class BookingActivity : AppCompatActivity() {

    companion object {
        // Prototype data kept in memory while the app process is running.
        val bookings = mutableListOf<Booking>()
        private val bookedSeatsByRoute = mutableMapOf<Int, MutableSet<Int>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val passengerInput = findViewById<EditText>(R.id.passengerInput)
        val seatInput = findViewById<EditText>(R.id.seatInput)
        val routeSpinner = findViewById<Spinner>(R.id.routeSpinner)
        val fareText = findViewById<TextView>(R.id.fareText)
        val bookButton = findViewById<Button>(R.id.bookButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        val routes = TransportRepository.routes

        val routeLabels = routes.map { "${it.name}: ${it.destination}" }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, routeLabels)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        routeSpinner.adapter = adapter

        fun updateFare() {
            val route = routes.getOrNull(routeSpinner.selectedItemPosition)
            fareText.text = route?.let { "Fare: KES ${it.fare}" } ?: "Fare: unavailable"
        }

        routeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                updateFare()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                fareText.text = "Fare: unavailable"
            }
        }

        bookButton.setOnClickListener {
            val passengerName = passengerInput.text.toString().trim()
            val seatNumber = seatInput.text.toString().toIntOrNull()
            val route = routes.getOrNull(routeSpinner.selectedItemPosition)

            if (passengerName.isBlank()) {
                passengerInput.error = "Enter passenger name"
                return@setOnClickListener
            }

            if (route == null) {
                Toast.makeText(this, "Select a route", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (seatNumber == null || seatNumber !in 1..route.totalSeats) {
                seatInput.error = "Enter a seat from 1 to ${route.totalSeats}"
                return@setOnClickListener
            }

            val bookedSeats = bookedSeatsByRoute.getOrPut(route.id) { mutableSetOf() }
            if (seatNumber in bookedSeats) {
                seatInput.error = "That seat is already booked"
                return@setOnClickListener
            }

            bookedSeats.add(seatNumber)
            bookings.add(
                Booking(
                    passengerName = passengerName,
                    routeName = route.name,
                    seatNumber = seatNumber,
                    fare = route.fare
                )
            )

            resultText.text =
                "Booking confirmed for $passengerName\n" +
                        "${route.name} - ${route.destination}\n" +
                        "Seat: $seatNumber | Fare: KES ${route.fare}"

            seatInput.text.clear()
            Toast.makeText(this, "Ticket booked", Toast.LENGTH_SHORT).show()
        }
    }
}