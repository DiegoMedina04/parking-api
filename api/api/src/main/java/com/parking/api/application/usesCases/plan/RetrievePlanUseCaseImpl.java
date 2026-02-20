package com.parking.api.application.usesCases.plan;

import com.parking.api.domain.models.Plan;
import com.parking.api.domain.ports.in.plan.RetrievePlanUseCase;
import com.parking.api.domain.ports.out.PlanRepositoryPort;
import reactor.core.publisher.Flux;

public class RetrievePlanUseCaseImpl  implements RetrievePlanUseCase {
    private final PlanRepositoryPort planRepositoryPort;

    public RetrievePlanUseCaseImpl(PlanRepositoryPort planRepositoryPort) {
        this.planRepositoryPort = planRepositoryPort;
    }

    @Override
    public Flux<Plan> getPlans() {
        return planRepositoryPort.findAll();
    }
}
