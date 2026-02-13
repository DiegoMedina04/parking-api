package com.parking.api.infrastructure.config;

import com.parking.api.application.services.UserService;
import com.parking.api.application.usesCases.CreateUserUseCaseImpl;
import com.parking.api.application.usesCases.RetrieveUserUseCaseImpl;
import com.parking.api.domain.models.User;
import com.parking.api.domain.ports.in.user.CreateUserUseCase;
import com.parking.api.domain.ports.in.user.RetrieveUserUseCase;
import com.parking.api.domain.ports.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public RetrieveUserUseCase retrieveUserUseCase(UserRepositoryPort userRepository) {
        return new RetrieveUserUseCaseImpl(userRepository);
    }

   @Bean
    public CreateUserUseCase createUserUseCase(UserRepositoryPort userRepository) {
        return new CreateUserUseCaseImpl(userRepository);
    }

   @Bean
    public UserService userService(
           RetrieveUserUseCase retrieveUserUseCase,
            CreateUserUseCase createUserUseCase
   ) {
        return new UserService(retrieveUserUseCase, createUserUseCase);
   }
}
