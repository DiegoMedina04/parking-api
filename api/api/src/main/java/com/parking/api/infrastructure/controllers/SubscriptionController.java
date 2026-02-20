package com.parking.api.infrastructure.controllers;

import com.parking.api.application.services.SubscriptionService;
import com.parking.api.domain.models.Subscription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }




    @GetMapping
    public ResponseEntity<Flux<Subscription>> findAll() {
        return ResponseEntity.ok(subscriptionService.getSubscriptions());
    }
    @PostMapping
    public ResponseEntity<Mono<Subscription>> save(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.save(subscription));
    }
}
