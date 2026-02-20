package com.parking.api.domain.ports.in.parking;

import com.parking.api.domain.models.Parking;
import reactor.core.publisher.Mono;

public interface CreateParkinUseCase {
    Mono<Parking> save(Parking parking);
}
