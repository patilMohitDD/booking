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
@Table(name = "auditorium")
public class Audi {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "capacity" , nullable = false)
    @NotNull(message = "Capacity cannot be 0")
    private int capacity;
}
