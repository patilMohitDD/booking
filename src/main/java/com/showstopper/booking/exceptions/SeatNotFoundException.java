package com.showstopper.booking.exceptions;

public class SeatNotFoundException extends Exception{
    public SeatNotFoundException(String message){
        super(message);
    }
}
