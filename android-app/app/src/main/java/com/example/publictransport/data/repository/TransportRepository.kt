package com.example.publictransport.data.repository

import com.example.publictransport.data.model.Route

/** Stage 1 sample data. Later stages replace this source with Room through the repository. */
object TransportRepository {
    val routes = listOf(
        Route(1, "Route 1", "Nairobi CBD - Rongai", 100.0, 5),
        Route(2, "Route 2", "Nairobi CBD - Kikuyu", 80.0, 5),
        Route(3, "Route 3", "Nairobi CBD - Thika", 150.0, 5),
        Route(4, "Route 4", "Nairobi CBD - Ngong", 90.0, 5)
    )
}
