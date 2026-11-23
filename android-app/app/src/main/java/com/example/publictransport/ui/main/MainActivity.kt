package com.example.publictransport.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.publictransport.R
import com.example.publictransport.data.repository.TransportRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val routesText = findViewById<TextView>(R.id.routesText)
        routesText.text = TransportRepository.routes.joinToString("\n\n") { route ->
            "${route.name}\n${route.destination}\nFare: KSh ${route.fare} | Seats: ${route.totalSeats}"
        }
    }
}
