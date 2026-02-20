package com.parking.api.infrastructure.repositories.plan;

import com.parking.api.domain.models.Plan;
import com.parking.api.domain.ports.out.PlanRepositoryPort;
import com.parking.api.infrastructure.entities.PlanEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class JpaPlanRepositoryAdapter implements PlanRepositoryPort {

    private final JpaPlanRepository jpaPlanRepository;
    public JpaPlanRepositoryAdapter(JpaPlanRepository jpaPlanRepository) {
        this.jpaPlanRepository = jpaPlanRepository;
    }

    @Override
    public Flux<Plan> findAll() {
        return  Mono.fromCallable(jpaPlanRepository::findAll)
                .subscribeOn(Schedulers.boundedElastic())
                .flatMapMany(Flux::fromIterable)
                .map(PlanEntity::toDomainModel);
        //.flatMapMany(users -> Flux.fromIterable(users))
        //flatMapMany -> Mono<List<User>>  →  Flux<User>


    }

    @Override
    public Mono<Plan> findById(String id) {

        return null;
    }

    @Override
    public Mono<Plan> save(Plan plan) {
        PlanEntity planEntity = PlanEntity.fromDomainModel(plan);
        return Mono.fromCallable(()-> jpaPlanRepository.save(planEntity))
                .subscribeOn(Schedulers.boundedElastic())
                .map(PlanEntity::toDomainModel);
    }

    @Override
    public Mono<Plan> update(Plan plan) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}
