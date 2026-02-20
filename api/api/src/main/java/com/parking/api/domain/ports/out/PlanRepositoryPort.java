package com.parking.api.domain.ports.out;

import com.parking.api.domain.models.Plan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanRepositoryPort {
    Flux<Plan> findAll();
    Mono<Plan> findById(String id);
    Mono<Plan> save(Plan user);
    Mono<Plan> update(Plan user);
    Mono<Void> delete(String id);
}
