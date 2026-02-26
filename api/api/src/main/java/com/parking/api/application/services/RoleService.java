package com.parking.api.application.services;

import com.parking.api.domain.models.Role;
import com.parking.api.domain.models.User;
import com.parking.api.domain.ports.in.role.CreateRoleUseCase;
import com.parking.api.domain.ports.in.role.RetrieveRoleUseCase;
import com.parking.api.domain.ports.in.user.CreateUserUseCase;
import com.parking.api.domain.ports.in.user.RetrieveUserUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RoleService implements RetrieveRoleUseCase, CreateRoleUseCase {


    private final RetrieveRoleUseCase retrieveRoleUseCase;
    private final CreateRoleUseCase createRoleUseCase;

    public RoleService(RetrieveRoleUseCase retrieveRoleUseCase, CreateRoleUseCase createRoleUseCase) {
        this.retrieveRoleUseCase = retrieveRoleUseCase;
        this.createRoleUseCase = createRoleUseCase;
    }

    @Override
    public Flux<Role> getRoles() {
        return retrieveRoleUseCase.getRoles();
    }

    @Override
    public Mono<Role> save(Role role) {
        return createRoleUseCase.save(role);
    }
}
