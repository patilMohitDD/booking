package com.showstopper.booking.model;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    private int id;
    private Show show;
    private List<Seat> seats;
    private BookingStatus status;

}

