package com.showstopper.booking.controller;

import com.showstopper.booking.model.Theatre;
import com.showstopper.booking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;
    @GetMapping("/")
    public ResponseEntity<List<Theatre>> getAllTheatre() {
        return ResponseEntity.ok(theatreService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createThreatre(@RequestBody Theatre theatre){
        int createdTheatre = theatreService.addTheatre(theatre);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTheatre);
    }
    @GetMapping("/info/{id}")
    public ResponseEntity<Theatre> getTheatreInfo(@PathVariable int id) throws Exception {
        Theatre getTheatreInfo = theatreService.getTheatreInfo(id);

        if (getTheatreInfo != null) {
            return ResponseEntity.ok(getTheatreInfo);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theatre> updateTheatreInfo(@PathVariable("id") int id, @RequestBody Theatre theatre) throws Exception {
        Theatre updatedTheatreInfo = theatreService.updateTheatreInfo(id, theatre);

        if (updatedTheatreInfo != null) {
            return ResponseEntity.ok(updatedTheatreInfo);
        }
        return ResponseEntity.notFound().build();
    }

}
