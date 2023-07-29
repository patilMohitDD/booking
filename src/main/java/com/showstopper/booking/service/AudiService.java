package com.showstopper.booking.service;

import com.showstopper.booking.model.Audi;
import com.showstopper.booking.model.Theatre;
import com.showstopper.booking.repository.AudiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudiService {
    @Autowired
    private AudiRepository audiRepository;
    private Audi audi;

    public List<Audi> getALlInfo() {
        return audiRepository.findAll();
    }

    public int createAudi(Audi audi) {
        Audi createdAudi = audiRepository.save(audi);
        return createdAudi.getId();
    }
}
