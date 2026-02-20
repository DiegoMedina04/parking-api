package com.parking.api.domain.models;

import com.parking.api.domain.SubscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    private String id;
    private Parking parking;
    private Plan plan;
    private LocalDate startDate;
    private LocalDate endDate;
    private SubscriptionStatus status;
}
