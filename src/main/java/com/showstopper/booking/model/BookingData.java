package com.showstopper.booking.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


public class BookingData {
    private ArrayList<Booking> bookings = new ArrayList<>();
    public BookingData(){
        Booking firstBooking = new Booking(10, "AB-10", "MI:6", " 3pm", "6pm");
        Booking secondBooking = new Booking(12, "AB-11", "MI:7", " 9am", "12pm");

        bookings.add(firstBooking);
        bookings.add(secondBooking);
    }

    public ArrayList<Booking>  getALLBookings(){
        return bookings;
    }

    public Optional<Booking> getBookingById(int id) {
        Optional <Booking> requiredBooking = this.bookings.stream()
                .filter(booking-> booking.get_id() == id)
                .findFirst();

        return requiredBooking;

        }
    }

