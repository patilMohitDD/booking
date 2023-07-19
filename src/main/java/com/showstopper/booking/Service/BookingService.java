package com.showstopper.booking.Service;

import com.showstopper.booking.model.Booking;

import java.util.Random;
import java.util.ArrayList;
import java.util.Optional;


public class BookingService {
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Integer> bookingsId = new ArrayList<>();
    public BookingService(){

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
        return this.bookings;
    }

    public Optional<Booking> getBookingById(int id) {
        Optional <Booking> requiredBooking = this.bookings.stream()
                .filter(booking-> booking.getId()  == id)
                .findFirst();
        return requiredBooking;
        }
    public int generateID(){
        Random random = new Random();
        int generatedId = random.nextInt(100);

        while (!bookingsId.isEmpty() & !this.bookingsId.contains(generatedId)) {
            generatedId = random.nextInt(100);
        }
        return generatedId;
    }

    public  int saveBooking(Booking newBooking){
        newBooking.setId(this.generateID());
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

    public Boolean deleteBookingByID(int id){
        Optional <Booking> requiredBooking = this.bookings.stream()
                .filter(booking-> booking.getId()  == id)
                .findFirst();

        if (requiredBooking.isPresent()){
            this.bookings.remove(requiredBooking);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
