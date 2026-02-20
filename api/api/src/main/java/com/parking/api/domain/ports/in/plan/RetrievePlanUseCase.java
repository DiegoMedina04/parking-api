package com.parking.api.domain.ports.in.plan;

import com.parking.api.domain.models.Plan;
import reactor.core.publisher.Flux;

public interface RetrievePlanUseCase {
    Flux<Plan> getPlans();
}
