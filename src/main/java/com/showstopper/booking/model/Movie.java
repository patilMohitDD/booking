package com.showstopper.booking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "movie")
public class Movie{
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "title" , nullable = false)
    @NotNull(message = "Title cannot be null")
    private String title;

    @Column(name = "genre" , nullable = false)
    @NotNull(message = "Genre cannot be null")
    private String genre;

    @Column(name = "duration" , nullable = false)
    @NotNull(message = "Duration cannot be null")
    private float duration;

    @Column(name = "rating" , nullable = false)
    @NotNull(message = "Name cannot be null")
    private float rating;
}
