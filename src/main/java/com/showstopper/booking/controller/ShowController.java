package com.showstopper.booking.controller;

import com.showstopper.booking.model.Show;
import com.showstopper.booking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("show")
public class ShowController{
    @Autowired
    private ShowService showService;

    @GetMapping("/")
    public ResponseEntity<List<Show>> getAllShows(){
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/{id}")
    public ResponseEntity getShowById(@PathVariable int id){
        try{
            Show requiredShowInfo = showService.getShowByID(id);
            return ResponseEntity.ok(requiredShowInfo);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createShow(@RequestBody Show show){
        int savedShowId = showService.createShow(show);
        return ResponseEntity.ok(savedShowId);
    }

    @PutMapping("/{id}")
    public  ResponseEntity updateShowInfo(@PathVariable int id, @RequestBody Show show) {
        try {
            Show updatedShow = showService.updateShow(id, show);
            return ResponseEntity.ok(updatedShow);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteShowInfo(@PathVariable int id){
        Boolean deletedShow = showService.deleteShow(id);
        if(deletedShow){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Show Id Not Present");
    }

}
