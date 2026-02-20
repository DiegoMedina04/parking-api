package com.parking.api.application.usesCases.subscription;

import com.parking.api.domain.models.Subscription;
import com.parking.api.domain.ports.in.subscription.CreateSubscriptionUseCase;
import com.parking.api.domain.ports.out.SubscriptionRepositoryPort;
import reactor.core.publisher.Mono;

public class CreateSubscriptionUseCaseImpl implements CreateSubscriptionUseCase {
    private final SubscriptionRepositoryPort subscriptionRepositoryPort;

    public CreateSubscriptionUseCaseImpl(SubscriptionRepositoryPort subscriptionRepositoryPort) {
        this.subscriptionRepositoryPort = subscriptionRepositoryPort;
    }


    @Override
    public Mono<Subscription> save(Subscription subscription) {
        return subscriptionRepositoryPort.save(subscription);
    }
}
