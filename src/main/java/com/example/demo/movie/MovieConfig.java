package com.example.demo.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.JANUARY;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository repository){
        return args -> {
            Movie Star_Wars = new Movie(
                    1L,
                    "Revenge of the sith",
                    "George Lucas",
                    "Star wars movie",
                    LocalDate.of(2001, APRIL, 20)
            );

            Movie Cars = new Movie(
                    1L,
                    "Cars",
                    "Disney",
                    "A disney movie",
                    LocalDate.of(2004, JANUARY, 10)
            );

            repository.saveAll(
                    List.of(Star_Wars, Cars)
            );
        };
    }
}
