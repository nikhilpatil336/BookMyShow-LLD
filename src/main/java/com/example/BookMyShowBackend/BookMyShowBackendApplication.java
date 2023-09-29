package com.example.BookMyShowBackend;

import com.example.BookMyShowBackend.Model.*;
import com.example.BookMyShowBackend.MultiThreading.BookingServiceRunMethod;
import com.example.BookMyShowBackend.Repositories.InMemoryRepositories.InMemoryBookingRepository;
import com.example.BookMyShowBackend.Repositories.InMemoryRepositories.InMemoryShowSeatRepository;
import com.example.BookMyShowBackend.Services.BookingService;
import com.example.BookMyShowBackend.Services.ServicesImpl.BookingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootApplication
public class BookMyShowBackendApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(BookMyShowBackendApplication.class, args);

		User user = User.builder().name("Nikhil").build();
		user.setId(1);

		Screen screen1 = Screen.builder().ScreenNumber(1).ScreenType(ScreenType.TWO_D).build();
		screen1.setId(1);
		List<Screen> screens = List.of(screen1);

		Theater theater = Theater.builder().name("INOX").screens(screens).address("Bengaluru").build();
		theater.setId(1);

		Movie movie = Movie.builder().name("Joker").movieType(MovieType.TWO_D).cast(new ArrayList<>()).build();
		movie.setId(1);

		SeatType seatType1 = SeatType.builder().theater(theater).seatType("Gold").build();
		seatType1.setId(1);
		SeatType seatType2 = SeatType.builder().theater(theater).seatType("Silver").build();
		seatType2.setId(2);
		List<SeatType> seatTypes = List.of(seatType1, seatType2);

		Seat seat1 = Seat.builder().seatNumber(1).seatType(seatType1).build();
		seat1.setId(1);
		Seat seat2 = Seat.builder().seatNumber(2).seatType(seatType1).build();
		seat2.setId(2);

		Seat seat3 = Seat.builder().seatNumber(3).seatType(seatType2).build();
		seat3.setId(3);
		Seat seat4 = Seat.builder().seatNumber(4).seatType(seatType2).build();
		seat4.setId(4);

		List<Seat> seats = List.of(seat1, seat2, seat3, seat4);

		screen1.setSeats(seats);

		ShowSeat showSeat1 = ShowSeat.builder().seat(seat1).showSeatStatus(ShowSeatStatus.AVAILABLE).build();
		showSeat1.setId(1);
		ShowSeat showSeat2 = ShowSeat.builder().seat(seat2).showSeatStatus(ShowSeatStatus.AVAILABLE).build();
		showSeat2.setId(2);
		ShowSeat showSeat3 = ShowSeat.builder().seat(seat3).showSeatStatus(ShowSeatStatus.AVAILABLE).build();
		showSeat3.setId(3);
		ShowSeat showSeat4 = ShowSeat.builder().seat(seat4).showSeatStatus(ShowSeatStatus.AVAILABLE).build();
		showSeat4.setId(4);

		List<ShowSeat> showSeats = List.of(showSeat1, showSeat2, showSeat3);
		List<ShowSeat> showSeats1 = List.of(showSeat3, showSeat4);

		ShowSeatType showSeatType1 = ShowSeatType.builder().seatType(seatType1).price(200).build();
		showSeatType1.setId(1);
		ShowSeatType showSeatType2 = ShowSeatType.builder().seatType(seatType2).price(100).build();
		showSeatType2.setId(2);
		List<ShowSeatType> showSeatTypes = List.of(showSeatType1, showSeatType2);

		Show show = Show.builder().movie(movie).screen(screen1).startTime(LocalTime.parse("10:00")).endTime(LocalTime.parse("11:00")).language(Language.HINDI).showSeatTypes(showSeatTypes).showSeats(showSeats).build();
		show.setId(1);

		showSeat1.setShow(show);
		showSeat2.setShow(show);
		showSeat3.setShow(show);
		showSeat4.setShow(show);

		showSeatType1.setShow(show);
		showSeatType2.setShow(show);

		ExecutorService e = Executors.newCachedThreadPool();

		BookingService bookingService = new BookingServiceImpl(new InMemoryShowSeatRepository(), new InMemoryBookingRepository());

		Future<Booking> booking = e.submit(new BookingServiceRunMethod(bookingService, user, show, showSeats, 1L));
		Future<Booking> booking2 = e.submit(new BookingServiceRunMethod(bookingService, user, show, showSeats1, 2L));

//		e.submit(() -> {
//			Booking booking = bookingService.createBooking(user, show, showSeats, 1L);
//		});

		System.out.println(booking.get().getId());
        System.out.println(booking.get().getUser());
        System.out.println(booking.get().getShow());

		System.out.println(booking2.get().getId());
		System.out.println(booking2.get().getUser());
		System.out.println(booking2.get().getShow());

	}

}
