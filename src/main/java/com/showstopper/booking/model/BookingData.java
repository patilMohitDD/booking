package com.showstopper.booking.model;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


public class BookingData {
    private ArrayList<Booking> bookings = new ArrayList<>();
    public BookingData(){

//        Booking firstBooking = new Booking(10, "AB-10", "MI:6", " 3pm", "6pm");
//        Booking secondBooking = new Booking(12, "AB-11", "MI:7", " 9am", "12pm");
//        Booking thirdBooking = new Booking(14, "AB-12", "MI:8", " 10am", "1pm");
//        Booking fourthBooking = new Booking(16, "AB-13", "MI:9", " 11am", "2pm");
//        Booking fifthBooking = new Booking(18, "AB-14", "MI:10", " 11am", "1pm");
//
//        bookings.add(firstBooking);
//        bookings.add(secondBooking);
//        bookings.add(thirdBooking);
//        bookings.add(fourthBooking);
//        bookings.add(fifthBooking);
    }

    public ArrayList<Booking>  getALLBookings(){
        return bookings;
    }

    public Optional<Booking> getBookingById(int id) {
        Optional <Booking> requiredBooking = this.bookings.stream()
                .filter(booking-> booking.getId()  == id)
                .findFirst();
        return requiredBooking;
        }

    public  int saveBooking(Booking newBooking){
        newBooking.setId(1);
        this.bookings.add(newBooking);

        return newBooking.getId();
    }

    public Booking updateBooking(int id, Booking updateBooking) throws Exception {
        Optional <Booking> requiredBooking = this.bookings.stream()
            .filter(booking-> booking.getId()  == id)
            .findFirst();

        if ( requiredBooking.isPresent() ){
            Booking existingBooking  = requiredBooking.get();
            existingBooking.setCustomerBookingID( updateBooking.getCustomerBookingID() );

            return existingBooking;
        }

        throw new Exception("ID not Found");

    }
}

