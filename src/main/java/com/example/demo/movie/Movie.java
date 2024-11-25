package com.example.demo.movie;

import java.time.LocalDate;

@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id;
    private String name;
    private String director;
    private String Description;
    private LocalDate released;

    public Movie() {
    }

    public Movie(Long id, String name, String director, String description, LocalDate released) {
        this.id = id;
        this.name = name;
        this.director = director;
        Description = description;
        this.released = released;
    }

    public Movie(LocalDate released, String name, String director, String description) {
        this.released = released;
        this.name = name;
        this.director = director;
        Description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", Description='" + Description + '\'' +
                ", released=" + released +
                '}';
    }
}
