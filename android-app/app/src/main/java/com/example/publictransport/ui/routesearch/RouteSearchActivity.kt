package com.example.publictransport.ui.routesearch

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.publictransport.R
import com.example.publictransport.data.repository.TransportRepository

class RouteSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routesearch)

        val originInput = findViewById<EditText>(R.id.originInput)
        val destinationInput = findViewById<EditText>(R.id.destinationInput)
        val searchButton = findViewById<Button>(R.id.searchButton)
        val resultsList = findViewById<ListView>(R.id.routesList)

        searchButton.setOnClickListener {
            val origin = originInput.text.toString().trim()
            val destination = destinationInput.text.toString().trim()

            if (origin.isBlank() || destination.isBlank()) {
                Toast.makeText(this, "Enter both locations", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val matches = TransportRepository.getRoutes().filter { route ->
                route.origin.contains(origin, ignoreCase = true) &&
                        route.destination.contains(destination, ignoreCase = true)
            }

            resultsList.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                matches.map { "${it.name}: ${it.origin} → ${it.destination} | ${it.fare}" }
            )

            if (matches.isEmpty()) {
                Toast.makeText(this, "No matching routes found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}