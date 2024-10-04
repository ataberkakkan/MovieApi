package com.movieflix.movieApi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieflix.movieApi.dtos.MovieDto;
import com.movieflix.movieApi.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public ResponseEntity<MovieDto> addMovie(@RequestPart MultipartFile file, @RequestPart String movieDto) throws IOException {
        MovieDto dto = convertToMovieDto(movieDto);

        return new ResponseEntity<>(movieService.addMovie(dto, file), HttpStatus.CREATED);

    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable int movieId) {
        return ResponseEntity.ok(movieService.getMovie(movieId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PutMapping("/update/{movieId}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable int movieId, @RequestPart MultipartFile file, @RequestPart String movieDto) throws IOException {
        if (file.isEmpty()) {
            file = null;
        }

        MovieDto dto = convertToMovieDto(movieDto);

        return ResponseEntity.ok(movieService.updateMovie(movieId, dto, file));
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable int movieId) throws IOException {
        return ResponseEntity.ok(movieService.deleteMovie(movieId));

    }

    private MovieDto convertToMovieDto(String movieDtoObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(movieDtoObject, MovieDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
