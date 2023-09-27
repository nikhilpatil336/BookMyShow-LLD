package com.example.BookMyShowBackend.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ShowSeat extends BaseModel {

    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
