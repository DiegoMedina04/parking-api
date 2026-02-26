package com.parking.api.domain.models;

import com.parking.api.infrastructure.entities.ParkingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String id;
    private String name;
    private String document;
    private String password;
    private String email;
    private Role role;
    private List<Parking> parking;


}
