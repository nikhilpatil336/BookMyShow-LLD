package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.*;
import com.example.BookMyShowBackend.Repositories.BookingRepository;
import com.example.BookMyShowBackend.Repositories.ShowSeatRepository;
import com.example.BookMyShowBackend.Services.BookingService;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceImpl implements BookingService
{
    ShowSeatRepository showSeatRepository;
    BookingRepository bookingRepository;

    public BookingServiceImpl(ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(User user, Show show, List<ShowSeat> showSeats, long id) throws RuntimeException
    {
        //check if the showseats are available
        // if all showseat available -> change the status to locked
        // else -> throw an excetion

        //go through the showSeats and calculate the total amount

        //create a booking and set the user, show, showSeats, the total amount, booking status = pending.
        //save the booking object in repo

        //return the booking object

        List<ShowSeat> currentShowSeats = new ArrayList<>(showSeats);
        double totalPrice = 0;

        synchronized (show)
        {
            for (ShowSeat currentshowSeat : currentShowSeats) {
                if (currentshowSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
                    currentshowSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
                else
                    throw new RuntimeException("Show Seats are not available");
            }

            for (ShowSeat currentshowSeat : currentShowSeats)
                showSeatRepository.saveShowSeat(currentshowSeat);

            for(ShowSeat currentshowSeat : currentShowSeats) {
                Seat seat = currentshowSeat.getSeat();
                for (ShowSeatType currentshowSeatType : show.getShowSeatTypes())
                    if(seat.getSeatType().equals(currentshowSeatType.getSeatType()))
                        totalPrice += currentshowSeatType.getPrice();
            }
        }

        //Booking booking = Booking.builder().User(user).Show(show).ShowSeats(currentShowSeats).Price(totalPrice).BookingStatus(BookingStatus.PENDING).build();

        Booking booking = Booking.builder().user(user).show(show).showSeats(currentShowSeats).price(totalPrice).bookingStatus(BookingStatus.PENDING).build();
        booking.setId(id);

        return bookingRepository.saveBooking(booking);
    }
}
