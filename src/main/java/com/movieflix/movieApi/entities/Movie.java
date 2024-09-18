package com.movieflix.movieApi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Title cannot be empty!")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Director cannot be empty!")
    private String director;

    @Column(nullable = false)
    @NotBlank(message = "Studio cannot be empty!")
    private String studio;

    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private Set<String> movieCast;

    @Column(nullable = false)
    @NotBlank(message = "Release Year cannot be empty!")
    private int releaseYear;

    @Column(nullable = false)
    @NotBlank(message = "Poster cannot be empty!")
    private String poster;
}
