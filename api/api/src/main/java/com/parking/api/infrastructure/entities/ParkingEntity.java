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

    @ManyToOne
    private UserEntity user;

    public static ParkingEntity fromDomainModel(Parking parkingLot) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(parkingLot.getUser().getId());
        return new ParkingEntity(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getAddress(),
                null,
                userEntity
        );
    }

    public Parking toDomainModel() {
        return new Parking(
                id,
                name,
                address,
                null,
                user ==null ? null: user.toDomainModel()
        );
    }
}