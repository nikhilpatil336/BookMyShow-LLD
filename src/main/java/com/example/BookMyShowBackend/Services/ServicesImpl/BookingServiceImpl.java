package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.*;
import com.example.BookMyShowBackend.Repositories.*;
import com.example.BookMyShowBackend.Services.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        boolean isLocked, isAllLocked = true;

        //how to handle a deadLock situation (Best way to handle deadLock is to sort the showSeats and then do the operations)
        List<Long> sortedShowSeatsIds = showSeatsId.stream().sorted().collect(Collectors.toList());

        //locking all show seats
        for(Long sortShowSeatId : sortedShowSeatsIds)
        {
            isLocked = showSeatRepository.getLockOverShowSeats(sortShowSeatId);
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


//if we sync the booking method
//only one person in entire world can access that method at one time, that will make the application very slow


//if we take a lock on show object
//if 2 person trying to book different ShowSeats of same show at a same time then one person has to wait
//till the other person completes the booking
//(in reality this solution is acceptable cause booking will take 4 to 5 seconds, which is acceptable a person can wait that much time)
//Show 1 -> 1, 2, 3
//Show 1 -> 4, 5
//this is not possible at a same time


//taking a lock on ShowSeat object
//we are further imporving the performace of application
//if 2 person trying to book different ShowSeats of same show at a same time then it is allowed with this approach
//allowed
//Show 1 -> 1, 2, 3
//Show 1 -> 4, 5

//not allowed
//Show 1 -> 1, 2, 3
//Show 1 -> 3, 4
//trying to book same seat at a same time is not allowed


//handiling the deadlock situation
//Show 1 -> 3, 2, 1
//Show 1 -> 1, 2, 3
//then person 1 will take lock on 3 first and person 2 will take a lock on seat 1 first
//and then at the end deadlock will happen and both had to release the resources
//because of this no one will be able to book the ticket, which is not good
//to handle this situation, the best solution is to sort the showSeatIds and then do the operations
