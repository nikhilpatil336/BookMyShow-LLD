package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.Movie;
import com.example.BookMyShowBackend.Services.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }
}
