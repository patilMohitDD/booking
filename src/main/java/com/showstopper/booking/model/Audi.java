package com.showstopper.booking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "auditorium")
public class Audi {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "capacity" , nullable = false)
    @NotNull(message = "Capacity cannot be 0")
    private int capacity;

    @OneToMany(cascade = CascadeType.ALL)
    @NotNull(message = "seats cannot be null")
    private List<Seat> seats;
}
