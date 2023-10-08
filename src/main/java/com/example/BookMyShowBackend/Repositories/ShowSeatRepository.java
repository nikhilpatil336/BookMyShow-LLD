package com.example.BookMyShowBackend.Repositories;

import com.example.BookMyShowBackend.Model.ShowSeat;

import java.util.List;

public interface ShowSeatRepository {

    ShowSeat saveShowSeat(ShowSeat showSeat);

    ShowSeat updateShowSeat(ShowSeat showSeat);

    ShowSeat getShowSeatById(Long currentshowSeatId);

    List<ShowSeat> getAllShowSeats();

    boolean getLockOverShowSeats(Long showSeatId);

    boolean unlockShowSeats(Long showSeatId);
}
