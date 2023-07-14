package com.showstopper.booking.controller;
//import com.showstopper.booking.model.Booking;
import com.showstopper.booking.model.Booking;
import com.showstopper.booking.model.BookingData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("bookings")
public class BookingController {
    @GetMapping("/")
    public ResponseEntity<ArrayList<Booking>> getAllBookings() {
        BookingData  allBookings = new BookingData();
        return ResponseEntity.ok(allBookings.getALLBookings());

    }

    @GetMapping("{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id){
        BookingData allBookings = new BookingData();
        Optional<Booking> bookingById = allBookings.getBookingById(id);

        if (bookingById.isPresent()) {
            return ResponseEntity.ok(bookingById.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
