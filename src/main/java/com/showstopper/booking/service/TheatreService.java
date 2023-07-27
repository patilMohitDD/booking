package com.showstopper.booking.service;
import com.showstopper.booking.model.Theatre;
import com.showstopper.booking.repository.TheatreRepository;
import com.showstopper.booking.utils.CustomValidator;

import jakarta.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    private CustomValidator customValidator = new CustomValidator();
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
    public Theatre updateTheatreInfo(int id, Theatre theatre) throws Exception {
        Optional<Theatre> requiredTheatreInfo = theatreRepository.findById(id);

        if ( requiredTheatreInfo.isPresent() ) {
            Theatre existingTheatreInfo = requiredTheatreInfo.get();

            Set<ConstraintViolation<Theatre>> violations = this.customValidator.validate(theatre);
            if (violations.size() > 0) {
                List<String> errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
                throw new Exception (String.join("\n", errors));
            }

            existingTheatreInfo.setName(theatre.getName());
            existingTheatreInfo.setLocation(theatre.getLocation());
            Theatre updatedTheatreInfo  = theatreRepository.save(existingTheatreInfo);

            return updatedTheatreInfo;
        }

        throw new Exception("ID not Found");
    }
}
