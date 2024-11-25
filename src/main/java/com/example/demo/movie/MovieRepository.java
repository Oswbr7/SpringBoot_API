package com.example.demo.movie;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public class MovieRepository extends JpaRepository<Movie, Long>{

    @Query("SELECT m FROM Movie m WHERE m.name = ?1 ")
    Optional<Movie> findMovieByName(String name);
}
