# Feature 6 – Personalized Recommendation System

## Objective

Provide personalized flight and hotel recommendations based on a user's booking history.

## Components Added

### RecommendationService

Responsibilities:

* Read user booking history
* Analyze previously booked flights and hotels
* Generate recommendations using existing data
* Return relevant flights and hotels

### RecommendationController

Endpoints:

GET /recommendations/flights/{userId}

GET /recommendations/hotels/{userId}

## Flight Recommendation Logic

1. Load user booking history.
2. Filter bookings where type = Flight.
3. Load booked flights using FlightRepository.
4. Identify source and destination patterns.
5. Recommend other flights with matching source or destination.

Example:

Booked Flight:

Jaipur → Delhi

Recommended Flights:

Jaipur → Mumbai

Delhi → Bangalore

## Hotel Recommendation Logic

1. Load user booking history.
2. Filter bookings where type = Hotel.
3. Load booked hotels using HotelRepository.
4. Identify frequently visited locations.
5. Recommend hotels in the same location.

Example:

Booked Hotel:

Goa Beach Resort

Location:

Goa

Recommended Hotels:

Goa Palm Resort

Goa Luxury Stay

## Repositories Reused

* UserRepository
* FlightRepository
* HotelRepository

## Database Impact

No new collections created.

No schema changes.

All recommendations are generated dynamically using existing data.

## Benefits

* Personalized user experience
* Increased engagement
* Encourages repeat bookings
* Simple rule-based recommendation engine

## API Endpoints

### Flight Recommendations

GET /recommendations/flights/{userId}

Returns:

List<Flight>

### Hotel Recommendations

GET /recommendations/hotels/{userId}

Returns:

List<Hotel>

## Outcome

Users receive recommendations based on their actual booking history without requiring machine learning or additional database structures.