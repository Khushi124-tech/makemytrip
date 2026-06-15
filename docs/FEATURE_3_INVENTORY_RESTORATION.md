# Feature 3 – Inventory Restoration During Cancellation

## Objective

Ensure cancelled bookings restore inventory back to the system.

## Flight Inventory Restoration

When a flight booking is cancelled:

availableSeats += bookedQuantity

Example:

Before cancellation:

Available Seats = 98

Cancelled Quantity = 2

After cancellation:

Available Seats = 100

## Hotel Inventory Restoration

When a hotel booking is cancelled:

availableRooms += bookedQuantity

Example:

Before cancellation:

Available Rooms = 48

Cancelled Quantity = 2

After cancellation:

Available Rooms = 50

## Booking Removal

Cancelled bookings are removed from:

Users.Booking

## User Persistence

After booking removal:

userRepository.save(user)

is executed.

## Benefits

* Accurate inventory tracking
* Prevents seat/room leakage
* Keeps booking data synchronized
* Maintains consistency across cancellations

## Outcome

Inventory automatically returns to the system whenever a cancellation occurs.