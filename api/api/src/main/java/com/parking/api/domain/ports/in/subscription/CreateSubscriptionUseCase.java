package com.parking.api.domain.ports.in.subscription;

import com.parking.api.domain.models.Subscription;
import reactor.core.publisher.Mono;

public interface CreateSubscriptionUseCase {
    Mono<Subscription> save(Subscription subscription);
}
