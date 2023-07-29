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
    public ResponseEntity<List<Theatre>> getAllTheatre() { return ResponseEntity.ok(theatreService.getAll()); }

    @PostMapping("/create")
    public ResponseEntity<Integer> createTheatre(@RequestBody Theatre theatre){
        int createdTheatre = theatreService.addTheatre(theatre);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTheatre);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity getTheatreInfo(@PathVariable int id){
        try {
            Theatre getTheatreInfo = theatreService.getTheatreInfo(id);
            if (getTheatreInfo != null) {
                return ResponseEntity.ok(getTheatreInfo);
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Theatre> deleteTheatreInfo(@PathVariable int id){
        Boolean deleteTheatre = theatreService.deleteTheatre(id);

        if(deleteTheatre){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
