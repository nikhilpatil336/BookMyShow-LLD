package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Screen extends BaseModel{

    private int ScreenNumber;
    private ScreenType ScreenType;
    private List<Seat> seats;
}
