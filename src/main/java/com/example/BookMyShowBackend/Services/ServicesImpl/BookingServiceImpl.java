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
    public Booking createBooking(User user, Show show, List<Long> showSeatsId, long id) throws RuntimeException
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
        double totalPrice = 0, count = 0;
        boolean isLocked = true, isAllLocked = true;

        //locking all show seats
        for(Long currentshowSeatId : currentShowSeatIds)
        {
            isLocked = showSeatRepository.getLockOverShowSeats(currentshowSeatId);
            if(!isLocked)
            {
                isAllLocked = false;
                break;
            }
            count++;
        }

        //checking if all show seats are locked if not return empty booking object
        if(!isAllLocked)
        {
            for(int i = 0; i < count; i++)
            {
                showSeatRepository.unlockShowSeats(currentShowSeatIds.get(i));
            }
            return Booking.builder().bookingStatus(BookingStatus.NOT_BOOKED).build();
        }

        //getting all show seats in a list
        for(Long currentshowSeatId : currentShowSeatIds)
            currentShowSeats.add(showSeatRepository.getShowSeatById(currentshowSeatId));

        //checking if all show seats are available if not return empty booking object
        for (ShowSeat currentshowSeat : currentShowSeats)
            if (!currentshowSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                for (Long currentshowSeatId : currentShowSeatIds)
                    showSeatRepository.unlockShowSeats(currentshowSeatId);
                return Booking.builder().bookingStatus(BookingStatus.NOT_BOOKED).build();
            }

        //changing status to locked and updating it in showseat repo
        for (ShowSeat currentshowSeat : currentShowSeats){
            currentshowSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.updateShowSeat(currentshowSeat);
        }

        //calculating the total price
        for(ShowSeat currentshowSeat : currentShowSeats) {
            Seat seat = currentshowSeat.getSeat();
            for (ShowSeatType currentshowSeatType : show.getShowSeatTypes())
                if(seat.getSeatType().equals(currentshowSeatType.getSeatType()))
                    totalPrice += currentshowSeatType.getPrice();
        }

        //unlocking all show seats after doing all the checking
        for(Long currentshowSeatId : currentShowSeatIds)
            showSeatRepository.unlockShowSeats(currentshowSeatId);

        //creating booking object
        Booking booking = Booking.builder().user(user).show(show).showSeats(currentShowSeats).price(totalPrice).bookingStatus(BookingStatus.PENDING).build();
        booking.setId(id);

        return bookingRepository.saveBooking(booking);
    }
}
