package com.parking.api.infrastructure.config;

import com.parking.api.application.services.SubscriptionService;
import com.parking.api.application.usesCases.subscription.CreateSubscriptionUseCaseImpl;
import com.parking.api.application.usesCases.subscription.RetrieveSubscriptionUseCaseImpl;
import com.parking.api.domain.ports.in.subscription.CreateSubscriptionUseCase;
import com.parking.api.domain.ports.in.subscription.RetrieveSubscriptionUseCase;
import com.parking.api.domain.ports.out.SubscriptionRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionConfig {

    @Bean
    public RetrieveSubscriptionUseCase retrieveSubscriptionUseCase(SubscriptionRepositoryPort subscriptionRepositoryPort) {
        return new RetrieveSubscriptionUseCaseImpl(subscriptionRepositoryPort);
    }

   @Bean
    public CreateSubscriptionUseCase createSubscriptionUseCase(SubscriptionRepositoryPort subscriptionRepositoryPort) {
        return new CreateSubscriptionUseCaseImpl(subscriptionRepositoryPort);
    }

   @Bean
    public SubscriptionService subscriptionService(
           RetrieveSubscriptionUseCase retrieveSubscriptionUseCase,
            CreateSubscriptionUseCase createSubscriptionUseCase
   ) {
        return new SubscriptionService(retrieveSubscriptionUseCase, createSubscriptionUseCase);
   }
}
