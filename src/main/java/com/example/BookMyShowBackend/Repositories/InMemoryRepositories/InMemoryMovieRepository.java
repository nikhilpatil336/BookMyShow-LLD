package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Movie;
import com.example.BookMyShowBackend.Repositories.MovieRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMovieRepository implements MovieRepository {

    Map<Long, Movie> movieMap = new HashMap<>();
    @Override
    public Movie saveMovie(Movie movie) {
        return movieMap.put(movie.getId(), movie);
    }
}
