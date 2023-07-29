package com.showstopper.booking.controller;

import com.showstopper.booking.model.Audi;
import com.showstopper.booking.service.AudiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("audi")
public class AudiController {
    @Autowired
    private AudiService audiService;
    @GetMapping("/")
    public ResponseEntity<List<Audi>> getAllAudi(){
        return ResponseEntity.ok(audiService.getALlInfo());
    }

    @PostMapping("/create")
    public  ResponseEntity<Integer> createAudi(@RequestBody Audi audi){
        int createAudiID = audiService.createAudi(audi);
        return  ResponseEntity.ok(createAudiID);
    }

    @GetMapping("/{id}")
    public  ResponseEntity getAudiByID(@PathVariable int id){
        try {
            Audi requiredAudi = audiService.getAudiByID(id);
            return ResponseEntity.ok(requiredAudi);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity updateAudi(@PathVariable int id, @RequestBody Audi audi){
        try {
            Audi updateAudi = audiService.updateAudi(id,audi);
            return ResponseEntity.ok(updateAudi);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAudi(@PathVariable int id) {

        Boolean deleteAudi = audiService.deleteAudi(id);
        if (deleteAudi) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Id Not Present");
    }
}

