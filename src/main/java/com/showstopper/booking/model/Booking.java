package com.showstopper.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// lomBOk
public class Booking {
    private int id;
    private String customerBookingID;
    private String movieName;
    private String startTime;
    private String endTime;
}
