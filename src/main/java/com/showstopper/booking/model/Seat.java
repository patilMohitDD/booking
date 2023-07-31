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
@Table(name = "Seat")
public class Seat {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "seatNumber" , nullable = false)
    @NotNull(message = "Capacity cannot be 0")
    private String seatNumber;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Seat Status cannot be null")
    private SeatStatus status;
}
