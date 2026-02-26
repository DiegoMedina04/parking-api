package com.parking.api.application.usesCases.role;

import com.parking.api.domain.models.Role;
import com.parking.api.domain.ports.in.role.RetrieveRoleUseCase;
import com.parking.api.domain.ports.out.RoleRepositoryPort;
import reactor.core.publisher.Flux;

public class RetrieveRoleUseCaseImpl  implements RetrieveRoleUseCase {
    private final RoleRepositoryPort roleRepositoryPort;

    public RetrieveRoleUseCaseImpl(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }

    @Override
    public Flux<Role> getRoles() {
        return roleRepositoryPort.findAll();
    }
}
