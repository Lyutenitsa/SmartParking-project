package com.sioux.smartparkingapp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ParkingSpot")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long parkingSpot_id;

    @Column(name = "occupied")
    private Boolean occupied;
}
