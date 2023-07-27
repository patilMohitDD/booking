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
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name" , nullable = false)
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "location" , nullable = false)
    @NotNull(message = "Location cannot be null")
    private String location;

}
