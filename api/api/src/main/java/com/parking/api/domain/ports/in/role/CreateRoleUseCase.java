package com.parking.api.domain.ports.in.role;

import com.parking.api.domain.models.Role;
import com.parking.api.domain.models.User;
import reactor.core.publisher.Mono;

public interface CreateRoleUseCase {
    Mono<Role> save(Role role);
}
