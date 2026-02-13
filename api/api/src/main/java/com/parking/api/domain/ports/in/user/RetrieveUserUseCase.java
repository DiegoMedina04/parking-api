package com.parking.api.domain.ports.in.user;

import com.parking.api.domain.models.User;
import reactor.core.publisher.Flux;

public interface RetrieveUserUseCase {
    Flux<User> getUsers();
}
