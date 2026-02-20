package com.parking.api.domain.ports.out;

import com.parking.api.domain.models.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubscriptionRepositoryPort {
    Flux<Subscription> findAll();
    Mono<Subscription> findById(String id);
    Mono<Subscription> save(Subscription subscription);
    Mono<Subscription> update(Subscription subscription);
    Mono<Void> delete(String id);
}
