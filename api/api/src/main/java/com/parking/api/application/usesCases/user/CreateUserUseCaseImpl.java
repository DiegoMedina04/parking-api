package com.parking.api.application.usesCases.user;

import com.parking.api.domain.models.User;
import com.parking.api.domain.ports.in.user.CreateUserUseCase;
import com.parking.api.domain.ports.out.UserRepositoryPort;
import reactor.core.publisher.Mono;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    @Override
    public Mono<User> save(User user) {
        return userRepositoryPort.save(user);
    }
}
