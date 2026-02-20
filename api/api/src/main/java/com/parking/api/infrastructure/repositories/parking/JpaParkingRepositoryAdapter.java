package com.parking.api.infrastructure.repositories.parking;

import com.parking.api.domain.models.Parking;
import com.parking.api.domain.ports.out.ParkingRepositoryPort;
import com.parking.api.infrastructure.entities.ParkingEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class JpaParkingRepositoryAdapter implements ParkingRepositoryPort {

    private final JpaParkingRepository jpaParkingRepository;
    public JpaParkingRepositoryAdapter(JpaParkingRepository jpaParkingRepository) {
        this.jpaParkingRepository = jpaParkingRepository;
    }

    @Override
    public Flux<Parking> findAll() {
        return  Mono.fromCallable(jpaParkingRepository::findAll)
                .subscribeOn(Schedulers.boundedElastic())
                .flatMapMany(Flux::fromIterable)
                .map(ParkingEntity::toDomainModel);
        //.flatMapMany(users -> Flux.fromIterable(users))
        //flatMapMany -> Mono<List<User>>  →  Flux<User>


    }

    @Override
    public Mono<Parking> findById(String id) {

        return null;
    }

    @Override
    public Mono<Parking> save(Parking parking) {
        ParkingEntity parkingEntity = ParkingEntity.fromDomainModel(parking);
        return Mono.fromCallable(()-> jpaParkingRepository.save(parkingEntity))
                .subscribeOn(Schedulers.boundedElastic())
                .map(ParkingEntity::toDomainModel);
    }

    @Override
    public Mono<Parking> update(Parking plan) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}
