package com.showstopper.booking.service;

import com.showstopper.booking.exceptions.SeatNotFoundException;
import com.showstopper.booking.model.Seat;
import com.showstopper.booking.repository.SeatRepository;
import com.showstopper.booking.utils.CustomValidator;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    private Seat seat;
    private CustomValidator customValidator =  new CustomValidator();

    public List<Seat> getAllSeatsInfo(){
        return seatRepository.findAll();
    }

    public int createSeat(Seat seat) {
        Seat createdSeat = seatRepository.save(seat);
        return createdSeat.getId();
    }

    public Seat getSeatByID(int id) throws SeatNotFoundException {
        Optional<Seat> requiredSeat = seatRepository.findById(id);

        if(requiredSeat.isPresent()){
            Seat fetchedSeat = requiredSeat.get();
            return fetchedSeat;
        }
        throw new SeatNotFoundException("Seat is not present");
    }

    public Seat updateSeatStatus(int id, Seat newSeatStatus) throws Exception {
        Set<ConstraintViolation<Seat>> violations = this.customValidator.validate(newSeatStatus);
        if (!violations.isEmpty()) {
            List<String> errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new Exception (String.join("\n", errors));
        }

        Optional<Seat> requiredSeat = seatRepository.findById(id);
        if(requiredSeat.isPresent()){
            Seat updatingSeatStatus = requiredSeat.get();
            updatingSeatStatus.setStatus(newSeatStatus.getStatus());

            Seat updatedSeat =  seatRepository.save(updatingSeatStatus);
            return updatedSeat;
        }
        throw new SeatNotFoundException("Seat Id not present in the database");
    }

    public Boolean deleteSeat(int id) {
        Optional<Seat> requiredSeat = seatRepository.findById(id);

        if(requiredSeat.isPresent()){
            seatRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
