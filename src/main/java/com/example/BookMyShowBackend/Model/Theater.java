package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Theater extends BaseModel{

    private String name;
    private String address;
    private List<Screen> screens;

}
