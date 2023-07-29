package com.showstopper.booking.exceptions;

public class MovieNotFoundException extends Exception {
    public  MovieNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
