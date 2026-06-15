# Feature 1 – Review & Rating System

## Objective

Enable users to submit reviews and ratings for hotels and flights.

## Components Added

### Review Model

Stores:

* id
* userEmail
* targetType
* targetId
* rating
* comment
* createdAt

### Review Repository

MongoDB repository for storing and retrieving reviews.

### Review Service

Business logic layer:

* Save reviews
* Validate rating range (1–5)
* Retrieve flight reviews
* Retrieve hotel reviews

### Review Controller

Endpoints:

POST /reviews

GET /reviews/flight/{id}

GET /reviews/hotel/{id}

## Database

MongoDB Collection:
reviews

## Validation

Rating must be between 1 and 5.

## Outcome

Users can submit and view reviews without affecting existing booking functionality.