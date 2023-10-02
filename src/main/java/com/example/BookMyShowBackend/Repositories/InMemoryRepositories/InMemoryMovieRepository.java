package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Movie;
import com.example.BookMyShowBackend.Repositories.MovieRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryMovieRepository implements MovieRepository {

    Map<Long, Movie> movieMap = new HashMap<>();
    @Override
    public Movie saveMovie(Movie movie) {
        movieMap.put(movie.getId(), movie);
        return movieMap.get(movie.getId());
    }
}
