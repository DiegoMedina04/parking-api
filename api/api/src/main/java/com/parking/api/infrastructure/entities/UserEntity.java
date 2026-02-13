package com.parking.api.infrastructure.entities;

import com.parking.api.domain.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Column(unique = true)
    private String identification;

    @Column(unique = true)
    private String email;
    private String password;

    public static UserEntity  toDomainModel(User user){
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getIdentification(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public  User fromDomainModel(){
        return new User(
                id,
                name,
                identification,
                email,
                password
        );
    }
}
