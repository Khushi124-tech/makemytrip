package com.makemytrip.makemytrip.services;
import com.makemytrip.makemytrip.models.Users;
import com.makemytrip.makemytrip.models.Users.Booking;
import com.makemytrip.makemytrip.models.Flight;
import com.makemytrip.makemytrip.models.Hotel;
import com.makemytrip.makemytrip.repositories.UserRepository;
import com.makemytrip.makemytrip.repositories.FlightRepository;
import com.makemytrip.makemytrip.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public Booking bookFlight(String userId,String flightId,int seats,double price,List<String> selectedSeats){
        System.out.println("[BOOKING_SERVICE] bookFlight started userId=" + userId
                + ", flightId=" + flightId
                + ", seats=" + seats
                + ", price=" + price
                + ", selectedSeats=" + selectedSeats);
        Optional<Users> usersOptional =userRepository.findById(userId);
        System.out.println("[BOOKING_SERVICE] user found=" + usersOptional.isPresent());
        Optional<Flight> flightOptional =flightRepository.findById(flightId);
        System.out.println("[BOOKING_SERVICE] flight found=" + flightOptional.isPresent());
        if(usersOptional.isPresent() && flightOptional.isPresent()){
            Users user=usersOptional.get();
            Flight flight=flightOptional.get();
            System.out.println("[BOOKING_SERVICE] loaded flight id=" + flight.getId()
                    + ", availableSeats=" + flight.getAvailableSeats());
            if(flight.getAvailableSeats() >= seats){
                int beforeSeats = flight.getAvailableSeats();
                flight.setAvailableSeats(flight.getAvailableSeats()- seats);
                System.out.println("[BOOKING_SERVICE] updating flight seats " + beforeSeats
                        + " -> " + flight.getAvailableSeats());
                Flight savedFlight = flightRepository.save(flight);
                System.out.println("[BOOKING_SERVICE] saved flight id=" + savedFlight.getId()
                        + ", availableSeats=" + savedFlight.getAvailableSeats());

                Booking booking=new Booking();
                booking.setType("Flight");
                booking.setBookingId(flightId);
                booking.setDate(LocalDate.now().toString());
                booking.setQuantity(seats);
                booking.setTotalPrice(price);
                booking.setSelectedSeats(selectedSeats);
                user.getBookings().add(booking);
                userRepository.save(user);
                return booking;
            }else {
                throw new RuntimeException("Not enough seats available");
            }
        }
        throw new RuntimeException("User or flight not found");
    }
    public Booking bookhotel(String userId,String hotelId,int rooms,double price,List<String> selectedRooms){
        Optional<Users> usersOptional =userRepository.findById(userId);
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
        if(usersOptional.isPresent() && hotelOptional.isPresent()){
            Users user=usersOptional.get();
            Hotel hotel=hotelOptional.get();
            if(hotel.getAvailableRooms() >= rooms){
                hotel.setAvailableRooms(hotel.getAvailableRooms()- rooms);
                hotelRepository.save(hotel);

                Booking booking=new Booking();
                booking.setType("Hotel");
                booking.setBookingId(hotelId);
                booking.setDate(LocalDate.now().toString());
                booking.setQuantity(rooms);
                booking.setTotalPrice(price);
                booking.setSelectedRooms(selectedRooms);
                user.getBookings().add(booking);
                userRepository.save(user);
                return booking;
            }else {
                throw new RuntimeException("Not enough rooms available");
            }
        }
        throw new RuntimeException("User or flight not found");
    }

}
