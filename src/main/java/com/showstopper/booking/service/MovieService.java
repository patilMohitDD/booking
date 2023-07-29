package com.showstopper.booking.service;

import com.showstopper.booking.exceptions.MovieNotFoundException;
import com.showstopper.booking.model.Movie;
import com.showstopper.booking.repository.MovieRepository;
import com.showstopper.booking.utils.CustomValidator;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService{
    @Autowired
    MovieRepository movieRepository;
    private Movie movie;
    private CustomValidator customValidator =  new CustomValidator();

    public List<Movie> getAllMovieDetails(){
        return movieRepository.findAll();
    }

    public int saveMovieDetail(Movie movie){
        Movie createdMovie = movieRepository.save(movie);
        return createdMovie.getId();
    }

    public Movie getMovieDetails(int id) throws MovieNotFoundException {
        Optional<Movie> requireMovie = movieRepository.findById(id);

        if(requireMovie.isPresent()){
            Movie fetchMovieInfo = requireMovie.get();
            return fetchMovieInfo;
        }
        throw new MovieNotFoundException("Movie Details not Present for the ID");
    }

    public Movie updateMovieDetail(int id, Movie newMovie) throws Exception {
        Set<ConstraintViolation<Movie>> violations = this.customValidator.validate(newMovie);
        if (!violations.isEmpty()) {
            List<String> errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new Exception (String.join("\n", errors));
        }

        Optional<Movie> requiredMovie = movieRepository.findById(id);

        if(requiredMovie.isPresent()){
            Movie fetchMovie = requiredMovie.get();

            fetchMovie.setDuration(newMovie.getDuration());
            fetchMovie.setGenre(newMovie.getGenre());
            fetchMovie.setRating(newMovie.getRating());
            fetchMovie.setTitle(newMovie.getTitle());

            Movie updatedMovie = movieRepository.save(fetchMovie);

            return updatedMovie;
        }

        throw new MovieNotFoundException("Movie not Present for Updation");
    }

    public Boolean deleteMovieDetails(int id){
        Optional<Movie> requiredAudi = movieRepository.findById(id);

        if(requiredAudi.isPresent()){
            movieRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
