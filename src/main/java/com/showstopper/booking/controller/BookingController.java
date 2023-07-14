package com.showstopper.booking.controller;
//import com.showstopper.booking.model.Booking;
import com.showstopper.booking.model.Call;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    @GetMapping("movie")
    public String sayHello() {
        return "Hello MoHit";
    }
    @GetMapping("all")
    public ArrayList getAllBookings() {
        Call  c1 = new Call();
        return c1.getALLBookings();

    }
    @GetMapping("id/{id}")
    public Object getBookingById(@PathVariable int id){
        Call c2 = new Call();
        return c2.getBookingById(id);

    }


}
