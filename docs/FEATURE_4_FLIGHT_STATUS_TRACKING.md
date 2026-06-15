# Feature 4 – Live Flight Status Tracking

## Objective

Provide real-time flight status management and tracking.

## Components Modified

### FlightStatus Enum

Values:

* ON_TIME
* BOARDING
* DELAYED
* CANCELLED
* LANDED

### Flight Model

Added:

* status field
* default value: ON_TIME
* getter and setter methods

### RootController

Added endpoints:

GET /flight/{id}/status

Returns current flight status.

PUT /flight/{id}/status?status=DELAYED

Updates flight status and persists changes.

## Database Impact

No new collections created.

Existing Flight documents now store status information.

## Benefits

* Real-time flight updates
* Improved customer experience
* Better operational visibility

## Example

Before:

Flight F101

Status: ON_TIME

After update:

PUT /flight/F101/status?status=DELAYED

Status: DELAYED