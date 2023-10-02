package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class City extends BaseModel{
    private String name;
    List<Theater> theaters;
}
