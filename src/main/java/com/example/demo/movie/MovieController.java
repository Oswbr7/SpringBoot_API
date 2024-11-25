package com.example.demo.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return MovieService.getMovies();
    }

    @PostMapping
    public void registerNewMovie(@RequestBody Movie movie){
        MovieService.addNewMovie(movie);
    }

    @DeleteMapping(path = "{movideId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId) {
        movieService.deleteMovie(id);
    }

    @PutMapping(path = "{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Long movieId,
            @RequestParam(required = false) String name
    ){
        MovieService.updateMovie(movieId, name);
    }
}
