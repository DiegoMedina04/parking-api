package com.parking.api.infrastructure.repositories.role;

import com.parking.api.domain.models.Role;
import com.parking.api.domain.models.User;
import com.parking.api.domain.ports.out.RoleRepositoryPort;
import com.parking.api.domain.ports.out.UserRepositoryPort;
import com.parking.api.infrastructure.entities.RoleEntity;
import com.parking.api.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class JpaRoleRepositoryAdapter implements RoleRepositoryPort {

    private final JpaRoleRepository jpaRoleRepository;
    public JpaRoleRepositoryAdapter(JpaRoleRepository jpaRoleRepository) {
        this.jpaRoleRepository = jpaRoleRepository;
    }

    @Override
    public Flux<Role> findAll() {
        return  Mono.fromCallable(jpaRoleRepository::findAll)
                .subscribeOn(Schedulers.boundedElastic())
                .flatMapMany(Flux::fromIterable)
                .map(RoleEntity::toDomainModel);
        //.flatMapMany(users -> Flux.fromIterable(users))
        //flatMapMany -> Mono<List<User>>  →  Flux<User>


    }

    @Override
    public Mono<Role> findById(String id) {

        return null;
    }

    @Override
    public Mono<Role> save(Role role) {
        RoleEntity roleEntity = RoleEntity.fromDomainModel(role);
        return Mono.fromCallable(()-> jpaRoleRepository.save(roleEntity))
                .subscribeOn(Schedulers.boundedElastic())
                .map(RoleEntity::toDomainModel);
    }

    @Override
    public Mono<Role> update(Role role) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}
