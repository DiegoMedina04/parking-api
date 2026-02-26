package com.parking.api.infrastructure.entities;

import com.parking.api.domain.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 20)
    private String document;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingEntity> parking;

    public static UserEntity fromDomainModel(User user) {

        RoleEntity roleRef = new RoleEntity();
        roleRef.setId(user.getRole().getId());


        List<ParkingEntity> parkingEntity = user.getParking() == null ? List.of() :
                user.getParking()
                        .stream()
                        .map(ParkingEntity::fromDomainModel)
                        .toList();


        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getPassword(),
                user.getEmail(),
                roleRef,
                parkingEntity
        );
    }

    public User toDomainModel() {
        return new User(
                id,
                name,
                document,
                password,
                email,
                role== null? null: role.toDomainModel(),
                null
        );
    }
}