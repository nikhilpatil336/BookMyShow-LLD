package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Exceptions.UserLockedException;
import com.example.BookMyShowBackend.Model.*;
import com.example.BookMyShowBackend.Repositories.*;
import com.example.BookMyShowBackend.Services.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService
{
    UserRepository userRepository;
    ScreenRepository screenRepository;
    TheaterRepository theaterRepository;
    MovieRepository movieRepository;
    SeatRepository seatRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    BookingRepository bookingRepository;
    SeatTypeRepository seatTypeRepository;
    ShowSeatTypeRepository showSeatTypeRepository;

    public BookingServiceImpl(UserRepository userRepository, ScreenRepository screenRepository, TheaterRepository theaterRepository, MovieRepository movieRepository, SeatRepository seatRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository, SeatTypeRepository seatTypeRepository, ShowSeatTypeRepository showSeatTypeRepository) {
        this.userRepository = userRepository;
        this.screenRepository = screenRepository;
        this.theaterRepository = theaterRepository;
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.seatTypeRepository = seatTypeRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    @Override
    public synchronized Booking createBooking(User user, Show show, List<Long> showSeatsId, long id) throws RuntimeException
    {
        //check if the showseats are available
        // if all showseat available -> change the status to locked
        // else -> throw an excetion

        //go through the showSeats and calculate the total amount

        //create a booking and set the user, show, showSeats, the total amount, booking status = pending.
        //save the booking object in repo

        //return the booking object

        List<Long> currentShowSeatIds = new ArrayList<>(showSeatsId);
        List<ShowSeat> currentShowSeats = new ArrayList<>();
        double totalPrice = 0;

        for(Long currentshowSeatId : currentShowSeatIds)
            currentShowSeats.add(showSeatRepository.getShowSeatById(currentshowSeatId));

        for (ShowSeat currentshowSeat : currentShowSeats)
            if (!currentshowSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
                throw new RuntimeException("Show Seats are not available");

        for (ShowSeat currentshowSeat : currentShowSeats){
            currentshowSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.updateShowSeat(currentshowSeat);
        }

        for(ShowSeat currentshowSeat : currentShowSeats) {
            Seat seat = currentshowSeat.getSeat();
            for (ShowSeatType currentshowSeatType : show.getShowSeatTypes())
                if(seat.getSeatType().equals(currentshowSeatType.getSeatType()))
                    totalPrice += currentshowSeatType.getPrice();
        }

        Booking booking = Booking.builder().user(user).show(show).showSeats(currentShowSeats).price(totalPrice).bookingStatus(BookingStatus.PENDING).build();
        booking.setId(id);

        return bookingRepository.saveBooking(booking);
    }
}
