package com.showstopper.booking.controller;
import com.showstopper.booking.model.Booking;
import com.showstopper.booking.Service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("bookings")
public class BookingController {
    private BookingService allBookings;
    public  BookingController(){
        this.allBookings = new BookingService();
    }
    @GetMapping("/")
    public ResponseEntity<ArrayList<Booking>> getAllBookings() {
        return ResponseEntity.ok(allBookings.getALLBookings());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id){
        Optional<Booking> bookingById = allBookings.getBookingById(id);
        if (bookingById.isPresent()) {
            return ResponseEntity.ok(bookingById.get());
        }
        return ResponseEntity.notFound().build();

    }
    @PostMapping("/create")
    public ResponseEntity<Integer> createBooking(@RequestBody Booking booking){
        int createdBooking = allBookings.saveBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") int id, @RequestBody Booking booking) throws Exception {
        Booking updatedBooking = allBookings.updateBooking(id, booking);
        if (updatedBooking != null) {
            return ResponseEntity.ok(updatedBooking);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookingByID(@PathVariable int id){
        boolean deletedBooking =  allBookings.deleteBookingByID(id);
        if(deletedBooking){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
