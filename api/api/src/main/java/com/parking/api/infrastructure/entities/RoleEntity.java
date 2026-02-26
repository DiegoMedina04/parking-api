package com.parking.api.infrastructure.entities;

import com.parking.api.domain.models.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserEntity> users;

    public static RoleEntity fromDomainModel(Role role) {
        return new RoleEntity(
                role.getId(),
                role.getName(),
                null
        );
    }

    public Role toDomainModel() {
        return new Role(
                id,
                name,
                null
        );
    }
}