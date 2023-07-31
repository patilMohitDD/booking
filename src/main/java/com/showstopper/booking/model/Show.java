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
@Table(name = "show")
public class Show {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "showTime" , nullable = false)
    @NotNull(message = "Show Time cannot cannot be null")
    private String showTime;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Show Must have a Theatre")
    private Theatre theatre;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Show Must have a Movie")
    private Movie movie;
}
