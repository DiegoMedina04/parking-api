package com.parking.api.domain.ports.in.parking;

import com.parking.api.domain.models.Parking;
import reactor.core.publisher.Flux;

public interface RetrieveParkingUseCase {
    Flux<Parking> getParkings();
}
