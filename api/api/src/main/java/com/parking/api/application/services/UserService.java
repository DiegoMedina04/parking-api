package com.parking.api.application.services;

import com.parking.api.domain.models.User;
import com.parking.api.domain.ports.in.user.CreateUserUseCase;
import com.parking.api.domain.ports.in.user.RetrieveUserUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserService implements RetrieveUserUseCase, CreateUserUseCase {


    private final RetrieveUserUseCase retrieveUserUseCase;
    private final CreateUserUseCase createUserUseCase;

    public UserService(RetrieveUserUseCase retrieveUserUseCase, CreateUserUseCase createUserUseCase) {
        this.retrieveUserUseCase = retrieveUserUseCase;
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public Flux<User> getUsers() {
        return retrieveUserUseCase.getUsers();
    }

    @Override
    public Mono<User> save(User user) {
        return createUserUseCase.save(user);
    }
}
