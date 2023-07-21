package com.showstopper.booking.Service;
import com.showstopper.booking.model.Booking;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookingService {
    private ArrayList<Booking> bookings = new ArrayList<>();
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

