# Feature 2 – Cancellation & Refund System

## Objective

Allow users to cancel existing bookings and receive refunds based on business rules.

## Components Added

### Refund Model

Stores:

* id
* bookingId
* userEmail
* refundAmount
* refundStatus
* cancelledAt

### Refund Repository

Handles MongoDB persistence for refund records.

### Cancellation Service

Responsibilities:

* Find booking
* Calculate refund amount
* Create refund record
* Store refund information

### Cancellation Controller

Endpoints:

POST /cancellations/{bookingId}

GET /cancellations/refund/{bookingId}

## Refund Status

* PENDING
* APPROVED
* REJECTED

## Refund Rules

Quantity <= 2 → 90%

Quantity <= 5 → 70%

Quantity > 5 → 50%

## Database Collection

refunds

## Outcome

Users can cancel bookings and receive refund records while preserving existing booking APIs.