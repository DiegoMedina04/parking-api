package com.parking.api.infrastructure.config;

import com.parking.api.application.services.PlanService;
import com.parking.api.application.usesCases.plan.CreatePlanUseCaseImpl;
import com.parking.api.application.usesCases.plan.RetrievePlanUseCaseImpl;
import com.parking.api.domain.ports.in.plan.CreatePlanUseCase;
import com.parking.api.domain.ports.in.plan.RetrievePlanUseCase;
import com.parking.api.domain.ports.out.PlanRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanConfig {

    @Bean
    public RetrievePlanUseCase retrievePlanUseCase(PlanRepositoryPort planRepository) {
        return new RetrievePlanUseCaseImpl(planRepository);
    }

   @Bean
    public CreatePlanUseCase createPlanUseCase(PlanRepositoryPort planRepository) {
        return new CreatePlanUseCaseImpl(planRepository);
    }

   @Bean
    public PlanService planService(
           RetrievePlanUseCase retrievePlanUseCase,
           CreatePlanUseCase createPlanUseCase
   ) {
        return new PlanService(retrievePlanUseCase, createPlanUseCase);
   }
}
