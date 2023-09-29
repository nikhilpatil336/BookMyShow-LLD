package com.example.BookMyShowBackend.Repositories;

import com.example.BookMyShowBackend.Model.ShowSeat;

public interface ShowSeatRepository {

    ShowSeat saveShowSeat(ShowSeat showSeat);

    ShowSeat updateShowSeat(ShowSeat showSeat);
}
