package com.movieflix.movieApi.services;

import com.movieflix.movieApi.dtos.MovieDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    MovieDto addMovie(MovieDto movie, MultipartFile file) throws IOException;

    MovieDto getMovie(int movieId);

    List<MovieDto> getAllMovies();

    MovieDto updateMovie(int movieId, MovieDto movieDto, MultipartFile file ) throws IOException;

    String deleteMovie(int movieId) throws IOException;
}
