package com.example.BookMyShowBackend;

import com.example.BookMyShowBackend.Controllers.*;
import com.example.BookMyShowBackend.Model.*;
import com.example.BookMyShowBackend.MultiThreading.BookingServiceRunMethod;
import com.example.BookMyShowBackend.Repositories.*;
import com.example.BookMyShowBackend.Repositories.InMemoryRepositories.*;
import com.example.BookMyShowBackend.Services.*;
import com.example.BookMyShowBackend.Services.ServicesImpl.*;
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

		UserRepository userRepository = new InMemoryUserRepository();
		ScreenRepository screenRepository = new InMemoryScreenRepository();
		TheaterRepository theaterRepository = new InMemoryTheaterRepository();
		MovieRepository movieRepository = new InMemoryMovieRepository();
		SeatRepository seatRepository = new InMemorySeatRepository();
		ShowRepository showRepository = new InMemoryShowRepository();
		ShowSeatRepository showSeatRepository = new InMemoryShowSeatRepository();
		BookingRepository bookingRepository = new InMemoryBookingRepository();
		SeatTypeRepository seatTypeRepository = new InMemorySeatTypeRepository();
		ShowSeatTypeRepository showSeatTypeRepository = new InMemoryShowSeatTypeRepository();
		CastRepository castRepositoy = new InMemoryCastRepository();
		CityRepository cityRepository = new InMemoryCityRepository();
		CreditCardRepository creditCardRepository = new InMemoryCreditCardRepository();
		DebitCardRepository debitCardRepository = new InMemoryDebitCardRepository();
		UPIRepository upiRepository = new InMemoryUPIRepository();

		BookingService bookingService = new BookingServiceImpl(userRepository, screenRepository, theaterRepository, movieRepository, seatRepository, showRepository, showSeatRepository, bookingRepository, seatTypeRepository, showSeatTypeRepository);
		CastService castService = new CastServiceImpl(castRepositoy);
		CityService cityService = new CityServiceImpl(cityRepository);
		CreditCardService creditCardService = new CreditCardServiceImpl(creditCardRepository);
		DebitCardService debitCardService = new DebitCardServiceImpl(debitCardRepository);
		MovieService movieService = new MovieServiceImpl(movieRepository);
		ScreenService screenService = new ScreenServiceImpl(screenRepository);
		SeatService seatService = new SeatServiceImpl(seatRepository);
		SeatTypeService seatTypeService = new SeatTypeServiceImpl(seatTypeRepository);
		ShowSeatService showSeatService = new ShowSeatServiceImpl(showSeatRepository);
		ShowSeatTypeService showSeatTypeService = new ShowSeatTypeServiceImpl(showSeatTypeRepository);
		ShowService showService = new ShowServiceImpl(showRepository);
		TheaterService theaterService = new TheaterServiceImpl(theaterRepository);
		UPIService upiService = new UPIServiceImpl(upiRepository);
		UserService userService = new UserServiceImpl(userRepository);


		BookingController bookingController = new BookingController(bookingService);
		CastController castController = new CastController(castService);
		CityController cityController = new CityController(cityService);
		CreditCardController creditCardController = new CreditCardController(creditCardService);
		DebitCardController debitCardController = new DebitCardController(debitCardService);
		MovieController movieController = new MovieController(movieService);
		ScreenController screenController = new ScreenController(screenService);
		SeatController seatController = new SeatController(seatService);
		SeatTypeController seatTypeController = new SeatTypeController(seatTypeService);
		ShowSeatController showSeatController = new ShowSeatController(showSeatService);
		ShowController showController = new ShowController(showService);
		TheaterController theaterController = new TheaterController(theaterService);
		UPIController upiController = new UPIController(upiService);
		UserController userController = new UserController(userService);


		//User
		User user = User.builder().name("Nikhil").build();
		user.setId(1);
		userRepository.saveUser(user);


		//Screen
		Screen screen1 = Screen.builder().ScreenNumber(1).ScreenType(ScreenType.TWO_D).build();
		screen1.setId(1);
		screenRepository.saveScreen(screen1);
		List<Screen> screens = List.of(screen1);


		//Theater
		Theater theater = Theater.builder().name("INOX").screens(screens).address("Bengaluru").build();
		theater.setId(1);
		theaterRepository.saveTheater(theater);


		//Movie
		Movie movie = Movie.builder().name("Joker").movieType(MovieType.TWO_D).cast(new ArrayList<>()).build();
		movie.setId(1);
		movieRepository.saveMovie(movie);


		//SeatType
		SeatType seatType1 = SeatType.builder().theater(theater).seatType("Gold").build();
		seatType1.setId(1);
		seatTypeRepository.saveSeatType(seatType1);
		SeatType seatType2 = SeatType.builder().theater(theater).seatType("Silver").build();
		seatType2.setId(2);
		seatTypeRepository.saveSeatType(seatType2);
		List<SeatType> seatTypes = List.of(seatType1, seatType2);


		//Seat
		Seat seat1 = Seat.builder().seatNumber(1).seatType(seatType1).build();
		seat1.setId(1);
		seatRepository.saveSeat(seat1);
		Seat seat2 = Seat.builder().seatNumber(2).seatType(seatType1).build();
		seat2.setId(2);
		seatRepository.saveSeat(seat2);

		Seat seat3 = Seat.builder().seatNumber(3).seatType(seatType2).build();
		seat3.setId(3);
		seatRepository.saveSeat(seat3);
		Seat seat4 = Seat.builder().seatNumber(4).seatType(seatType2).build();
		seat4.setId(4);
		seatRepository.saveSeat(seat4);

		List<Seat> seats = List.of(seat1, seat2, seat3, seat4);

		screen1.setSeats(seats);


		//ShowSeat
		ShowSeat showSeat1 = ShowSeat.builder().seat(seat1).showSeatStatus(ShowSeatStatus.AVAILABLE).build();
		showSeat1.setId(1);
		showSeatRepository.saveShowSeat(showSeat1);
		ShowSeat showSeat2 = ShowSeat.builder().seat(seat2).showSeatStatus(ShowSeatStatus.AVAILABLE).build();
		showSeat2.setId(2);
		showSeatRepository.saveShowSeat(showSeat2);
		ShowSeat showSeat3 = ShowSeat.builder().seat(seat3).showSeatStatus(ShowSeatStatus.AVAILABLE).build();
		showSeat3.setId(3);
		showSeatRepository.saveShowSeat(showSeat3);
		ShowSeat showSeat4 = ShowSeat.builder().seat(seat4).showSeatStatus(ShowSeatStatus.AVAILABLE).build();
		showSeat4.setId(4);
		showSeatRepository.saveShowSeat(showSeat4);

		List<ShowSeat> showSeats = List.of(showSeat1, showSeat2, showSeat3, showSeat4);

		//ShowSeatId list
		List<Long> showSeatsId = List.of(showSeat1.getId(), showSeat2.getId(), showSeat3.getId());
		List<Long> showSeatsId1 = List.of(showSeat3.getId(), showSeat4.getId());


		//ShowSeatType
		ShowSeatType showSeatType1 = ShowSeatType.builder().seatType(seatType1).price(200).build();
		showSeatType1.setId(1);
		showSeatTypeRepository.saveShowSeatType(showSeatType1);
		ShowSeatType showSeatType2 = ShowSeatType.builder().seatType(seatType2).price(100).build();
		showSeatType2.setId(2);
		showSeatTypeRepository.saveShowSeatType(showSeatType2);
		List<ShowSeatType> showSeatTypes = List.of(showSeatType1, showSeatType2);


		//Show
		Show show = Show.builder().movie(movie).screen(screen1).startTime(LocalTime.parse("10:00")).endTime(LocalTime.parse("11:00")).language(Language.HINDI).showSeatTypes(showSeatTypes).showSeats(showSeats).build();
		show.setId(1);
		showRepository.saveShow(show);

		showSeat1.setShow(show);
		showSeat2.setShow(show);
		showSeat3.setShow(show);
		showSeat4.setShow(show);

		showSeatType1.setShow(show);
		showSeatType2.setShow(show);


		//Executor Service
		ExecutorService e = Executors.newCachedThreadPool();

		Future<Booking> booking2 = e.submit(new BookingServiceRunMethod(bookingService, user, show, showSeatsId1, 2L));
		Future<Booking> booking = e.submit(new BookingServiceRunMethod(bookingService, user, show, showSeatsId, 1L));

		//ShowSeat showSeat = booking.get().getShowSeats().get(0);

		if(booking.get().getBookingStatus().equals(BookingStatus.NOT_BOOKED))
			System.out.println("Booking for 1st is not done");
		else
			System.out.println("Booking for 1st is done");

		if(booking2.get().getBookingStatus().equals(BookingStatus.NOT_BOOKED))
			System.out.println("Booking for 2nd is not done");
		else
			System.out.println("Booking for 2nd is done");


//		System.out.println(booking.get().getId());
//		System.out.println(booking.get().getUser());
//		System.out.println(booking.get().getShow());
//
//		System.out.println(booking2.get().getId());
//		System.out.println(booking2.get().getUser());
//		System.out.println(booking2.get().getShow());
	}
}
