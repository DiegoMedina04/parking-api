package com.parking.api.infrastructure.repositories.user;

import com.parking.api.domain.models.User;
import com.parking.api.domain.ports.out.UserRepositoryPort;
import com.parking.api.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;
    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Flux<User> findAll() {
        return  Mono.fromCallable(jpaUserRepository::findAll)
                .subscribeOn(Schedulers.boundedElastic())
                .flatMapMany(Flux::fromIterable)
                .map(UserEntity::fromDomainModel);
        //.flatMapMany(users -> Flux.fromIterable(users))
        //flatMapMany -> Mono<List<User>>  →  Flux<User>


    }

    @Override
    public Mono<User> findById(String id) {

        return null;
    }

    @Override
    public Mono<User> save(User user) {
        UserEntity userEntity = UserEntity.toDomainModel(user);
        return Mono.fromCallable(()-> jpaUserRepository.save(userEntity))
                .subscribeOn(Schedulers.boundedElastic())
                .map(UserEntity::fromDomainModel);
    }

    @Override
    public Mono<User> update(User user) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}
