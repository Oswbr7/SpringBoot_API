package com.example.demo.movie;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public static void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = MovieRepository.findMovieByName(movie.getName());
        if (movieOptional.isPresent()){
            throw new IllegalStateException("Name taken");
        }
        MovieRepository.save(movie);
    }

    public static List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void deleteMovie(Long movieId){
        boolean exists = movieRepository.existsById(movieId);
        if (!exists){
            throw new IllegalStateException("movie with id" + movieId + "Does not exists")
        }
        movieRepository.deleteById(movieId);
    }

    @Transactional
    public static void updateMovie(Long movieId, String name){
        Movie movie = MovieRepository.findById(movieId).orElseThrow(() -> new IllegalStateException("Movie with id" + movieId + "Does not exists"))
        if (name != null && name.length() > 0 && !Objects.equals(movie.getName(), movie)){
            movie.setName(name);
        }

    }

}
