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

//    @PutMapping("/update/{id}")
//    public  ResponseEntity<Audi> updateAudi(@PathVariable int id, @RequestBody Audi audi){
//        Audi updatedAudi = audiService.updateAudi(id, audi);
//
//        if (updatedAudi != null){
//            return ResponseEntity.ok(updatedAudi);
//        }
//
//        return ResponseEntity.notFound().build();
//    }

}

