package com.parking.api.infrastructure.config;

import com.parking.api.application.services.RoleService;
import com.parking.api.application.services.UserService;
import com.parking.api.application.usesCases.role.CreateRoleUseCaseImpl;
import com.parking.api.application.usesCases.role.RetrieveRoleUseCaseImpl;
import com.parking.api.application.usesCases.user.CreateUserUseCaseImpl;
import com.parking.api.application.usesCases.user.RetrieveUserUseCaseImpl;
import com.parking.api.domain.ports.in.role.CreateRoleUseCase;
import com.parking.api.domain.ports.in.role.RetrieveRoleUseCase;
import com.parking.api.domain.ports.in.user.CreateUserUseCase;
import com.parking.api.domain.ports.in.user.RetrieveUserUseCase;
import com.parking.api.domain.ports.out.RoleRepositoryPort;
import com.parking.api.domain.ports.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfig {

    @Bean
    public RetrieveRoleUseCase retrieveRoleUseCase(RoleRepositoryPort roleRepositoryPort) {
        return new RetrieveRoleUseCaseImpl(roleRepositoryPort);
    }

   @Bean
    public CreateRoleUseCase createRoleUseCase(RoleRepositoryPort roleRepositoryPort) {
        return new CreateRoleUseCaseImpl(roleRepositoryPort);
    }

   @Bean
    public RoleService roleService(
           RetrieveRoleUseCase retrieveRoleUseCase,
           CreateRoleUseCase createRoleUseCase
   ) {
        return new RoleService(retrieveRoleUseCase, createRoleUseCase);
   }
}
