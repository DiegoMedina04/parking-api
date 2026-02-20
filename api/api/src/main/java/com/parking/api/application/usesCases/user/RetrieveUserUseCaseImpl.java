package com.parking.api.application.usesCases.user;

import com.parking.api.domain.models.User;
import com.parking.api.domain.ports.in.user.RetrieveUserUseCase;
import com.parking.api.domain.ports.out.UserRepositoryPort;
import reactor.core.publisher.Flux;

public class RetrieveUserUseCaseImpl  implements RetrieveUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public RetrieveUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Flux<User> getUsers() {
        return userRepositoryPort.findAll();
    }
}
