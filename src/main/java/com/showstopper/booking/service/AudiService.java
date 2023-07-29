package com.showstopper.booking.service;

import com.showstopper.booking.exceptions.AudiNotFoundException;
import com.showstopper.booking.model.Audi;
import com.showstopper.booking.model.Theatre;
import com.showstopper.booking.repository.AudiRepository;
import com.showstopper.booking.utils.CustomValidator;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AudiService {
    @Autowired
    private AudiRepository audiRepository;
    private Audi audi;
    private CustomValidator customValidator =  new CustomValidator();

    public List<Audi> getALlInfo() {
        return audiRepository.findAll();
    }

    public int createAudi(Audi audi) {
        Audi createdAudi = audiRepository.save(audi);
        return createdAudi.getId();
    }

    public Audi getAudiByID(int id) throws AudiNotFoundException {
        Optional<Audi> requireAudi = audiRepository.findById(id);

        if (requireAudi.isPresent()){
            Audi fetchedAudi = requireAudi.get();
            return fetchedAudi;
        }
        throw new AudiNotFoundException("Audi is Not Present");
    }

    public Audi updateAudi(int id, Audi newAudi) throws Exception {
        Set<ConstraintViolation<Audi>> violations = this.customValidator.validate(newAudi);
        if (!violations.isEmpty()) {
            List<String> errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new Exception (String.join("\n", errors));
        }

        Optional<Audi> requireAudi = audiRepository.findById(id);
        if (requireAudi.isPresent()){
            Audi updatingAudi = requireAudi.get();
            updatingAudi.setCapacity(newAudi.getCapacity());

            Audi updatedAudi = audiRepository.save(updatingAudi);

            return updatedAudi;
        }
        throw new Exception("Audi is Not Present");
    }

    public Boolean deleteAudi(int id) {
        Optional<Audi> requiredAudi = audiRepository.findById(id);

        if(requiredAudi.isPresent()){
            audiRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}















