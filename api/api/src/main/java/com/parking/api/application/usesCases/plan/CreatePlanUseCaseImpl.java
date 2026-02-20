package com.parking.api.application.usesCases.plan;

import com.parking.api.domain.models.Plan;
import com.parking.api.domain.ports.in.plan.CreatePlanUseCase;
import com.parking.api.domain.ports.out.PlanRepositoryPort;
import reactor.core.publisher.Mono;

public class CreatePlanUseCaseImpl implements CreatePlanUseCase {
    private final PlanRepositoryPort planRepositoryPort;

    public CreatePlanUseCaseImpl(PlanRepositoryPort planRepositoryPort) {
        this.planRepositoryPort = planRepositoryPort;
    }


    @Override
    public Mono<Plan> save(Plan plan) {
        return planRepositoryPort.save(plan);
    }
}
