package com.parking.api.infrastructure.controllers;

import com.parking.api.application.services.PlanService;
import com.parking.api.domain.models.Plan;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/plan")
@Tag(name = "Planes")

public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @Operation(summary = "Listar todos los usuarios")
    @GetMapping
    public ResponseEntity<Flux<Plan>> findAll() {
        return ResponseEntity.ok(planService.getPlans());
    }
    @PostMapping
    public ResponseEntity<Mono<Plan>> save(@RequestBody Plan plan) {
        return ResponseEntity.ok(planService.save(plan));
    }
}
