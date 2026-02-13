package com.parking.api.domain.ports.in.user;

import com.parking.api.domain.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreateUserUseCase {
    Mono<User> save(User user);
}
