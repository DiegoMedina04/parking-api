package com.parking.api.application.services;

import com.parking.api.domain.models.Subscription;
import com.parking.api.domain.ports.in.subscription.CreateSubscriptionUseCase;
import com.parking.api.domain.ports.in.subscription.RetrieveSubscriptionUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SubscriptionService implements RetrieveSubscriptionUseCase, CreateSubscriptionUseCase {


    private final RetrieveSubscriptionUseCase retrieveSubscriptionUseCase;
    private final CreateSubscriptionUseCase createSubscriptionUseCase;

    public SubscriptionService(RetrieveSubscriptionUseCase retrieveSubscriptionUseCase, CreateSubscriptionUseCase createSubscriptionUseCase) {
        this.retrieveSubscriptionUseCase = retrieveSubscriptionUseCase;
        this.createSubscriptionUseCase = createSubscriptionUseCase;
    }

    @Override
    public Flux<Subscription> getSubscriptions() {
        return retrieveSubscriptionUseCase.getSubscriptions();
    }

    @Override
    public Mono<Subscription> save(Subscription subscription) {
        return createSubscriptionUseCase.save(subscription);
    }
}
