package com.parking.api.application.services;

import com.parking.api.domain.models.Parking;
import com.parking.api.domain.ports.in.parking.CreateParkinUseCase;
import com.parking.api.domain.ports.in.parking.RetrieveParkingUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ParkingService implements RetrieveParkingUseCase, CreateParkinUseCase {


    private final RetrieveParkingUseCase retrieveParkingUseCase;
    private final CreateParkinUseCase createParkinUseCase;

    public ParkingService(RetrieveParkingUseCase retrieveParkingUseCase, CreateParkinUseCase createParkinUseCase) {
        this.retrieveParkingUseCase = retrieveParkingUseCase;
        this.createParkinUseCase = createParkinUseCase;
    }

    @Override
    public Flux<Parking> getParkings() {
        return retrieveParkingUseCase.getParkings();
    }

    @Override
    public Mono<Parking> save(Parking parking) {
        return createParkinUseCase.save(parking);
    }
}
