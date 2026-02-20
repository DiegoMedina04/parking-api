package com.parking.api.application.usesCases.parking;

import com.parking.api.domain.models.Parking;
import com.parking.api.domain.ports.in.parking.CreateParkinUseCase;
import com.parking.api.domain.ports.out.ParkingRepositoryPort;
import reactor.core.publisher.Mono;

public class CreateParkingUseCaseImpl implements CreateParkinUseCase {
    private final ParkingRepositoryPort parkingRepositoryPort;

    public CreateParkingUseCaseImpl(ParkingRepositoryPort parkingRepositoryPort) {
        this.parkingRepositoryPort = parkingRepositoryPort;
    }


    @Override
    public Mono<Parking> save(Parking parking) {
        return parkingRepositoryPort.save(parking);
    }
}
