
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

fun main() {
    println("Public Transport Management System")
    println("Project scaffold created. Menu and features coming in the next commits.")
}

// ==========================================================
// Function: Display all available routes
// TODO (Tonny Oirere): implement route listing
// ==========================================================
fun displayRoutes(routes: List<Route>) {
    // TODO: implement in a later commit
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


