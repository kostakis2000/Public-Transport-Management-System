// Concept Note: https://docs.google.com/document/d/1SUtXPpcE_LUKfALtgBYfUFOllP6TEvdV/edit?usp=sharing&ouid=111873841346791276279&rtpof=true&sd=true
// Group 11
// 150574 Oladaro Kostakis Saruni
//151115- Tyron Odhiambo
//150917 Tonny Oirere
//190373 Lysa Munjogu
//168827 Ndirangu Sasha
//191854 Kamau Mary

/*
 * ==========================================================
 *  PUBLIC TRANSPORT MANAGEMENT SYSTEM
 * ==========================================================
 * Problem: Commuters struggle to know which routes/buses are
 * available, how many seats are left, and how much a trip
 * costs. Booking is often manual and disorganised.
 *
 * This prototype demonstrates a small working part of a larger
 * Public Transport Management System using Kotlin fundamentals:
 *   - Variables and constants (var, val)
 *   - Data types (String, Int, Double, Boolean)
 *   - Input and output (readLine, println)
 *   - Conditional statements (if/else, when)
 *   - Loops (while, for)
 *   - Collections (List, MutableList, Map)
 *
 * Implemented functionality:
 *   1. Display available routes/buses
 *   2. Book a ticket (with seat & fare handling)
 *   3. Check seat availability on a route
 *   4. Display a passenger's bookings
 */

// ---------- Data classes representing real-world entities ----------
// Contributed by: Oladaro Kostakis Saruni (150574)
data class Route(
    val id: Int,
    val name: String,
    val destination: String,
    val fare: Double,
    val totalSeats: Int
)

data class Booking(
    val passengerName: String,
    val routeName: String,
    val seatNumber: Int,
    val fare: Double
)

// ==========================================================
// main(): menu loop, constants and collections setup
// Contributed by: Tyron Odhiambo (151115)
// ==========================================================
fun main() {

    // ---------- Constants (fixed values that never change) ----------
    val SYSTEM_NAME = "CITY LINK PUBLIC TRANSPORT SYSTEM"
    val CURRENCY = "KES"

    // ---------- Collection: list of available routes (buses) ----------
    val routes: List<Route> = listOf(
        Route(1, "Route 1", "Nairobi CBD - Rongai", 100.0, 5),
        Route(2, "Route 2", "Nairobi CBD - Kikuyu", 80.0, 5),
        Route(3, "Route 3", "Nairobi CBD - Thika", 150.0, 5),
        Route(4, "Route 4", "Nairobi CBD - Ngong", 90.0, 5)
    )

    // ---------- Collection: seat availability per route ----------
    // Map: routeId -> mutable list of available seat numbers
    val seatAvailability: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    for (route in routes) {
        val seats = mutableListOf<Int>()
        for (seatNumber in 1..route.totalSeats) {
            seats.add(seatNumber)
        }
        seatAvailability[route.id] = seats
    }

    // ---------- Collection: all bookings made during this session ----------
    val bookings: MutableList<Booking> = mutableListOf()

    // ---------- Variable to control the main menu loop ----------
    var isRunning = true

    println("=".repeat(50))
    println(" $SYSTEM_NAME")
    println("=".repeat(50))
    println("Welcome! This system lets you view routes, check")
    println("seat availability, and book bus tickets.")

    // ---------- Main program loop ----------
    while (isRunning) {
        println("\n----------------------------------------")
        println("MAIN MENU")
        println("----------------------------------------")
        println("1. View available routes")
        println("2. Check seat availability")
        println("3. Book a ticket")
        println("4. View passenger bookings")
        println("5. Exit")
        print("Please select an option (1-5): ")

        val choice = readLine()?.trim()

        // ---------- Conditional statement: when ----------
        when (choice) {
            "1" -> displayRoutes(routes)

            "2" -> checkSeatAvailability(routes, seatAvailability)

            "3" -> bookTicket(routes, seatAvailability, bookings, CURRENCY)

            "4" -> viewPassengerBookings(bookings, CURRENCY)

            "5" -> {
                isRunning = false
                println("\nThank you for using $SYSTEM_NAME. Safe travels!")
            }

            else -> {
                // ---------- Conditional statement: if/else ----------
                println("Invalid option. Please enter a number between 1 and 5.")
            }
        }
    }
}

// ==========================================================
// Function: Display all available routes
// Demonstrates: for loop, string formatting, output
// Contributed by: Tonny Oirere (150917)
// ==========================================================
fun displayRoutes(routes: List<Route>) {
    println("\n----------------------------------------")
    println("AVAILABLE ROUTES")
    println("----------------------------------------")
    for (route in routes) {
        println("${route.id}. ${route.name} (${route.destination})")
        println("   Fare: KES ${route.fare} | Total Seats: ${route.totalSeats}")
    }
    println("----------------------------------------")
}

// ==========================================================
// Function: Check how many seats remain on a chosen route
// TODO (Lysa Munjogu): implement seat availability check
// ==========================================================
fun checkSeatAvailability(
    routes: List<Route>,
    seatAvailability: MutableMap<Int, MutableList<Int>>
) {
    // TODO: implement in a later commit
}

// ==========================================================
// Function: Book a ticket for a passenger
// TODO (Ndirangu Sasha): implement ticket booking
// ==========================================================
fun bookTicket(
    routes: List<Route>,
    seatAvailability: MutableMap<Int, MutableList<Int>>,
    bookings: MutableList<Booking>,
    currency: String
) {
    // TODO: implement in a later commit
}

// ==========================================================
// Function: View all bookings made by a specific passenger
// TODO (Kamau Mary): implement passenger booking history
// ==========================================================
fun viewPassengerBookings(bookings: MutableList<Booking>, currency: String) {
// TODO: implement in a later commit
}


