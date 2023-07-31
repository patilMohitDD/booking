package com.showstopper.booking.service;

import com.showstopper.booking.exceptions.ShowNotFoundException;
import com.showstopper.booking.model.Show;
import com.showstopper.booking.repository.ShowRepository;
import com.showstopper.booking.utils.CustomValidator;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    private CustomValidator customValidator = new CustomValidator();

    public List<Show> getAllShows(){
        return showRepository.findAll();
    }

    public Show getShowByID(int id) throws ShowNotFoundException {
        Optional<Show> requiredShowInfo = showRepository.findById(id);
        if(requiredShowInfo.isPresent()){
            Show fetchedShow = requiredShowInfo.get();
            return fetchedShow;
        }

        String message = "Show not Assigned to ID " + id;
        throw new ShowNotFoundException(message);
    }

    public int createShow(Show show){
        Show savedShow = showRepository.save(show);
        return savedShow.getId();
    }

    public Show updateShow(int id, Show show) throws Exception {
        Set<ConstraintViolation<Show>> violations = this.customValidator.validate(show);
        if (!violations.isEmpty()) {
            List<String> errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new Exception (String.join("\n", errors));
        }

        Optional<Show> requiredShow = showRepository.findById(id);
        if (requiredShow.isPresent()){

            Show updatingShow = requiredShow.get();
            updatingShow.setShowTime(show.getShowTime());
            updatingShow.setTheatre(show.getTheatre());
            updatingShow.setMovie(show.getMovie());

            Show updatedShowInfo = showRepository.save(updatingShow);
            return updatedShowInfo;
        }

        String message = "No Show is assigned to ID " + id;
        throw new ShowNotFoundException(message);
    }

    public Boolean deleteShow(int id) {
        Optional<Show> requiredShow = showRepository.findById(id);
        if(requiredShow.isPresent()){
            showRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
