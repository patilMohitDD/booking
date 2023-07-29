package com.showstopper.booking.controller;

import com.showstopper.booking.model.Movie;
import com.showstopper.booking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovieDetails(){
        return ResponseEntity.ok(movieService.getAllMovieDetails());
    }

    @PostMapping("/create")
    public  ResponseEntity<Integer> saveMovieDetail(@RequestBody Movie movie){
        int savedMovieId = movieService.saveMovieDetail(movie);
        return ResponseEntity.ok(savedMovieId);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMovieDetails(@PathVariable int id){
        try{
            Movie requiredMovie = movieService.getMovieDetails(id);
            return ResponseEntity.ok(requiredMovie);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovieDetails(@PathVariable int id, @RequestBody Movie movie){
        try {
            Movie newMovieDetails = movieService.updateMovieDetail(id, movie);
            return ResponseEntity.ok(newMovieDetails);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity  deletMovieDetails(@PathVariable int id){
        Boolean deleteAudi = movieService.deleteMovieDetails(id);
        if (deleteAudi) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Movie details Not Present");
    }
}
