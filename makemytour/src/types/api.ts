export type FlightStatus = "ON_TIME" | "BOARDING" | "DELAYED" | "CANCELLED" | "LANDED";
export type RefundStatus = "PENDING" | "APPROVED" | "REJECTED";
export type ReviewTargetType = "FLIGHT" | "HOTEL";

export interface Flight {
  id?: string;
  _id?: string;
  flightName: string;
  from: string;
  to: string;
  departureTime: string;
  arrivalTime: string;
  price: number;
  availableSeats: number;
  status?: FlightStatus;
}

export interface Hotel {
  id?: string;
  _id?: string;
  hotelName: string;
  location: string;
  pricePerNight: number;
  availableRooms: number;
  amenities?: string;
}

export interface Booking {
  type: "Flight" | "Hotel";
  bookingId: string;
  date: string;
  quantity: number;
  totalPrice: number;
  selectedSeats?: string[];
  selectedRooms?: string[];
}

export interface FlightBookingRequest {
  userId: string;
  flightId: string;
  seats: number;
  price: number;
  selectedSeats?: string[];
}

export interface HotelBookingRequest {
  userId: string;
  hotelId: string;
  rooms: number;
  price: number;
  selectedRooms?: string[];
}

export interface Review {
  id?: string;
  userEmail: string;
  targetType: ReviewTargetType;
  targetId: string;
  rating: number;
  comment: string;
  createdAt?: string;
}

export interface Refund {
  id?: string;
  bookingId: string;
  userEmail?: string;
  refundAmount: number;
  refundStatus: RefundStatus;
  cancelledAt?: string;
}

export interface User {
  id?: string;
  _id?: string;
  firstName: string;
  lastName: string;
  email: string;
  password?: string;
  role?: string;
  phoneNumber?: string;
  bookings?: Booking[];
}
