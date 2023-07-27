package com.showstopper.booking.model;

import jakarta.persistence.ForeignKey;

public class Show {
    private int id;
    private String showTime;
    private Theatre theatre;
    private Audi audi;
    private Movie movie;
}
