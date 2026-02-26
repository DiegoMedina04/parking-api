package com.parking.api.domain.ports.in.role;

import com.parking.api.domain.models.Role;
import reactor.core.publisher.Flux;

public interface RetrieveRoleUseCase {
    Flux<Role> getRoles();
}
