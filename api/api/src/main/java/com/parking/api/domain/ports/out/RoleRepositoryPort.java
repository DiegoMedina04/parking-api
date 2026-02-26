package com.parking.api.domain.ports.out;

import com.parking.api.domain.models.Role;
import com.parking.api.domain.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoleRepositoryPort {
    Flux<Role> findAll();
    Mono<Role> findById(String id);
    Mono<Role> save(Role role);
    Mono<Role> update(Role role);
    Mono<Void> delete(String id);
}
