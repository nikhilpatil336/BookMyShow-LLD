package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Movie extends BaseModel{

    private String name;
    private MovieType movieType;
    private List<Cast> cast;
}
