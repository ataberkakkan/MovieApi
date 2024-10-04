package com.movieflix.movieApi.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private int movieId;

    @NotBlank(message = "Title cannot be empty!")
    private String title;

    @NotBlank(message = "Director cannot be empty!")
    private String director;

    @NotBlank(message = "Studio cannot be empty!")
    private String studio;

    private Set<String> movieCast;

    private int releaseYear;

    @NotBlank(message = "Poster cannot be empty!")
    private String poster;

    @NotBlank(message = "Poster URL cannot be empty!")
    private String posterUrl;
}
