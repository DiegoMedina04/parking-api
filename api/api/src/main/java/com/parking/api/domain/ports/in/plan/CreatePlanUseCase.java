package com.parking.api.domain.ports.in.plan;

import com.parking.api.domain.models.Plan;
import reactor.core.publisher.Mono;

public interface CreatePlanUseCase {
    Mono<Plan> save(Plan plan);
}
