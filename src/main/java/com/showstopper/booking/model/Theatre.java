package com.showstopper.booking.model;

import jakarta.persistence.*;
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
    private String name;

    @Column(name = "location" , nullable = false)
    private String location;

}
