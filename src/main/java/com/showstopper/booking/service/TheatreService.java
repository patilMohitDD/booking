package com.showstopper.booking.service;

import com.showstopper.booking.model.Booking;
import com.showstopper.booking.model.Theatre;
import com.showstopper.booking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Theatre getTheatreInfo(int id) throws Exception {
        Optional<Theatre> requiredTheatreInfo = theatreRepository.findById(id);

        if ( requiredTheatreInfo.isPresent() ){
            Theatre existingTheatreInfo  = requiredTheatreInfo.get();
            return existingTheatreInfo;
        }
        throw new Exception("ID not Found");
    }
}
