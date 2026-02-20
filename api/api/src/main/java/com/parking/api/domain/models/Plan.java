package com.parking.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    private String id;
    private String name;
    private Integer maxPlaces;
    private Double monthlyValue;
    private List<Subscription> subscriptions;
}
