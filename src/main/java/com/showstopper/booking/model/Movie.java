package com.showstopper.booking.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    private int id;
    private String title;
    private String genre;
    private int duration;
    private String rating;
}
