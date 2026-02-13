package com.parking.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String id;
    private String name;
    private String identification;
    private String email;
    private String password;

}
