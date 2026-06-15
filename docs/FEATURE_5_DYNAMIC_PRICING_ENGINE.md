# Feature 5 – Dynamic Pricing Engine

## Objective

Automatically adjust flight and hotel prices based on inventory availability.

## Components Added

### PricingService

Methods:

* calculateFlightPrice(Flight flight)
* calculateHotelPrice(Hotel hotel)

## Flight Pricing Rules

Available Seats > 50

Price = Original Price

Available Seats 20–50

Price = Original Price + 10%

Available Seats < 20

Price = Original Price + 25%

## Hotel Pricing Rules

Available Rooms > 20

Price = Original Price

Available Rooms 5–20

Price = Original Price + 10%

Available Rooms < 5

Price = Original Price + 25%

## RootController Endpoints

GET /flight/{id}/dynamic-price

Returns calculated flight price.

GET /hotel/{id}/dynamic-price

Returns calculated hotel price.

## Database Impact

No schema changes.

No additional collections.

Pricing is calculated dynamically at runtime.

## Benefits

* Demand-based pricing
* Better inventory utilization
* Increased revenue potential

## Example

Flight Price: ₹10,000

Available Seats: 15

Calculated Price:

₹12,500 (+25%)

Hotel Price Per Night: ₹5,000

Available Rooms: 3

Calculated Price:

₹6,250 (+25%)