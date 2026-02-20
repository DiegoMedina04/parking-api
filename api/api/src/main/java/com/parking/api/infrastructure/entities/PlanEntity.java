package com.parking.api.infrastructure.entities;


import com.parking.api.domain.models.Plan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "planes")

public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer maxPlaces;
    private Double monthlyValue;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubscriptionEntity> subscription;

    public static PlanEntity  fromDomainModel(Plan plan){
        List<SubscriptionEntity> subscriptionsEntity =  plan.getSubscriptions() == null ? List.of() :
                plan.getSubscriptions()
                .stream()
                .map(SubscriptionEntity::fromDomainModel)
                .toList();
        return new PlanEntity(
                plan.getId(),
                plan.getName(),
                plan.getMaxPlaces(),
                plan.getMonthlyValue(),
                subscriptionsEntity
        );
    }

    public  Plan toDomainModel(){
        return new Plan(
                id,
                name,
                maxPlaces,
                monthlyValue,
                null
        );
    }
}
