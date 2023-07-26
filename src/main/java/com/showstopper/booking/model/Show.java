package com.showstopper.booking.model;

import jakarta.persistence.ForeignKey;

public class Show {
    private int id;
    private Theatre theatre;
    private Audi audi;
    private String showTime;
    private Movie movie;
}
