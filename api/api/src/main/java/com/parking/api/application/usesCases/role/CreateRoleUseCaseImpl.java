package com.parking.api.application.usesCases.role;

import com.parking.api.domain.models.Role;
import com.parking.api.domain.models.User;
import com.parking.api.domain.ports.in.role.CreateRoleUseCase;
import com.parking.api.domain.ports.in.user.CreateUserUseCase;
import com.parking.api.domain.ports.out.RoleRepositoryPort;
import com.parking.api.domain.ports.out.UserRepositoryPort;
import reactor.core.publisher.Mono;

public class CreateRoleUseCaseImpl implements CreateRoleUseCase {
    private final RoleRepositoryPort roleRepositoryPort;

    public CreateRoleUseCaseImpl(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }


    @Override
    public Mono<Role> save(Role role) {
        return roleRepositoryPort.save(role);
    }
}
