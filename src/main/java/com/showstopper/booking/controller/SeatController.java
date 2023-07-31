package com.showstopper.booking.controller;


import com.showstopper.booking.model.Audi;
import com.showstopper.booking.model.Seat;
import com.showstopper.booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seat")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("/")
    public ResponseEntity<List<Seat>> getAllSeats(){
        return ResponseEntity.ok(seatService.getAllSeatsInfo());
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createSeat(@RequestBody Seat seat){
        int createSeatId = seatService.createSeat(seat);
        return ResponseEntity.ok(createSeatId);
    }

    @GetMapping("/{id}")
    public  ResponseEntity getSeatByID(@PathVariable int id){
        try {
            Seat requiredSeat = seatService.getSeatByID(id);
            return ResponseEntity.ok(requiredSeat);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSeatStatus(@PathVariable int id, @RequestBody Seat seat){
        try{
            Seat updatedSeat = seatService.updateSeatStatus(id, seat);
            return ResponseEntity.ok(updatedSeat);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteSeat(@PathVariable int id){
        Boolean deletedSeat = seatService.deleteSeat(id);
        if(deletedSeat){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Seat Id Not Present");
    }

}

