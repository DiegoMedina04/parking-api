package com.parking.api.domain.ports.in.subscription;

import com.parking.api.domain.models.Subscription;
import reactor.core.publisher.Flux;

public interface RetrieveSubscriptionUseCase {
    Flux<Subscription> getSubscriptions();
}
