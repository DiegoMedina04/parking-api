package com.parking.api.application.services;

import com.parking.api.domain.models.Plan;
import com.parking.api.domain.ports.in.plan.CreatePlanUseCase;
import com.parking.api.domain.ports.in.plan.RetrievePlanUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlanService implements RetrievePlanUseCase, CreatePlanUseCase {


    private final RetrievePlanUseCase retrievePlanUseCase;
    private final CreatePlanUseCase createPlanUseCase;

    public PlanService(RetrievePlanUseCase retrievePlanUseCase, CreatePlanUseCase createPlanUseCase) {
        this.retrievePlanUseCase = retrievePlanUseCase;
        this.createPlanUseCase = createPlanUseCase;
    }

    @Override
    public Flux<Plan> getPlans() {
        return retrievePlanUseCase.getPlans();
    }

    @Override
    public Mono<Plan> save(Plan plan) {
        return createPlanUseCase.save(plan);
    }
}
