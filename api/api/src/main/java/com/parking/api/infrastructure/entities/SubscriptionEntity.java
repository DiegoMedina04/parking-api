package com.parking.api.infrastructure.entities;


import com.parking.api.domain.SubscriptionStatus;
import com.parking.api.domain.models.Subscription;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suscripciones")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private ParkingEntity parking;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PlanEntity plan;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate startDate;

    @Column(name = "fecha_fin")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private SubscriptionStatus status;

    public static SubscriptionEntity fromDomainModel(Subscription subscription) {
        PlanEntity planRef = new PlanEntity();
        planRef.setId(subscription.getPlan().getId());

        ParkingEntity parkingRef = new ParkingEntity();
        parkingRef.setId(subscription.getParking().getId());


        return new SubscriptionEntity(
                subscription.getId(),
                parkingRef,
                planRef,
                subscription.getStartDate(),
                subscription.getEndDate(),
                subscription.getStatus()
        );
    }

    public Subscription toDomainModel() {
        return new Subscription(
                id,
                parking.toDomainModel(),
                plan.toDomainModel(),
                startDate,
                endDate,
                status
        );
    }
}