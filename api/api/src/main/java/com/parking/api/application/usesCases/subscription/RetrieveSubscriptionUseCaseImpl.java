package com.parking.api.application.usesCases.subscription;

import com.parking.api.domain.models.Subscription;
import com.parking.api.domain.ports.in.subscription.RetrieveSubscriptionUseCase;
import com.parking.api.domain.ports.out.SubscriptionRepositoryPort;
import reactor.core.publisher.Flux;

public class RetrieveSubscriptionUseCaseImpl  implements RetrieveSubscriptionUseCase {
    private final SubscriptionRepositoryPort subscriptionRepositoryPort;

    public RetrieveSubscriptionUseCaseImpl(SubscriptionRepositoryPort subscriptionRepositoryPort) {
        this.subscriptionRepositoryPort = subscriptionRepositoryPort;
    }

    @Override
    public Flux<Subscription> getSubscriptions() {
        return subscriptionRepositoryPort.findAll();
    }
}
