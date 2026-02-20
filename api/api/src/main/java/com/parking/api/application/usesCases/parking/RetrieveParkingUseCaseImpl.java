package com.parking.api.application.usesCases.parking;

import com.parking.api.domain.models.Parking;
import com.parking.api.domain.ports.in.parking.RetrieveParkingUseCase;
import com.parking.api.domain.ports.out.ParkingRepositoryPort;
import reactor.core.publisher.Flux;

public class RetrieveParkingUseCaseImpl  implements RetrieveParkingUseCase {
    private final ParkingRepositoryPort parkingRepositoryPort;

    public RetrieveParkingUseCaseImpl(ParkingRepositoryPort parkingRepositoryPort) {
        this.parkingRepositoryPort = parkingRepositoryPort;
    }

    @Override
    public Flux<Parking> getParkings() {
        return parkingRepositoryPort.findAll();
    }
}
