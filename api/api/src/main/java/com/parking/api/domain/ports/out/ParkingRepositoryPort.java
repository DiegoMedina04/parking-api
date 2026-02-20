package com.parking.api.domain.ports.out;

import com.parking.api.domain.models.Parking;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParkingRepositoryPort {
    Flux<Parking> findAll();
    Mono<Parking> findById(String id);
    Mono<Parking> save(Parking user);
    Mono<Parking> update(Parking user);
    Mono<Void> delete(String id);
}
