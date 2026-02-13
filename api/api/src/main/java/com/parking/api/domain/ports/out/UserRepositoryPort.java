package com.parking.api.domain.ports.out;

import com.parking.api.domain.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepositoryPort{
    Flux<User> findAll();
    Mono<User> findById(String id);
    Mono<User> save(User user);
    Mono<User> update(User user);
    Mono<Void> delete(String id);
}
