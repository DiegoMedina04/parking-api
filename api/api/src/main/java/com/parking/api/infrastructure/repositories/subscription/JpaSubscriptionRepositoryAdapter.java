package com.parking.api.infrastructure.repositories.subscription;

import com.parking.api.domain.models.Subscription;
import com.parking.api.domain.ports.out.SubscriptionRepositoryPort;
import com.parking.api.infrastructure.entities.SubscriptionEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class JpaSubscriptionRepositoryAdapter implements SubscriptionRepositoryPort {

    private final JpaSubscriptionRepository jpaSubscriptionRepository;
    public JpaSubscriptionRepositoryAdapter(JpaSubscriptionRepository jpaSubscriptionRepository) {

        this.jpaSubscriptionRepository = jpaSubscriptionRepository;
    }

    @Override
    public Flux<Subscription> findAll() {
        return  Mono.fromCallable(jpaSubscriptionRepository::findAll)
                .subscribeOn(Schedulers.boundedElastic())
                .flatMapMany(Flux::fromIterable)
                .map(SubscriptionEntity::toDomainModel);
        //.flatMapMany(users -> Flux.fromIterable(users))
        //flatMapMany -> Mono<List<User>>  →  Flux<User>


    }

    @Override
    public Mono<Subscription> findById(String id) {

        return null;
    }

    @Override
    public Mono<Subscription> save(Subscription subscription) {
        SubscriptionEntity subscriptionEntity = SubscriptionEntity.fromDomainModel(subscription);
        return Mono.fromCallable(()-> jpaSubscriptionRepository.save(subscriptionEntity))
                .subscribeOn(Schedulers.boundedElastic())
                .map(SubscriptionEntity::toDomainModel);
    }

    @Override
    public Mono<Subscription> update(Subscription subscription) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}
