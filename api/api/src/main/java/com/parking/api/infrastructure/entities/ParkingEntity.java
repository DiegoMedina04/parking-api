package com.parking.api.infrastructure.entities;

import com.parking.api.domain.models.Parking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "parqueaderos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "parking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubscriptionEntity> subscription;

    public static ParkingEntity fromDomainModel(Parking parkingLot) {
        return new ParkingEntity(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getAddress(),
                null
        );
    }

    public Parking toDomainModel() {
        return new Parking(
                id,
                name,
                address,
                null
        );
    }
}