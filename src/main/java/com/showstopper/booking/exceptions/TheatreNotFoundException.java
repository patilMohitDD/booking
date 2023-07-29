package com.showstopper.booking.exceptions;

public class TheatreNotFoundException extends Exception{
    public  TheatreNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
