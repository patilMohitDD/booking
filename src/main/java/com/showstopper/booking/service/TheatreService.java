package com.showstopper.booking.service;

import com.showstopper.booking.model.Theatre;
import com.showstopper.booking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    public  int addTheatre(Theatre newTheatre) {
        Theatre theatre = theatreRepository.save(newTheatre);
        return theatre.getId();
    }

    public List<Theatre> getAll() {
        return theatreRepository.findAll();
    }
}